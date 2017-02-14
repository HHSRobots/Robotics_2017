package org.usfirst.frc.team554.robot.subsystems;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team554.robot.RobotMap;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Camera extends Subsystem {
	Thread visionThread;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Camera(){
		super();
		
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void startVisionThread(){
    	visionThread = new Thread(() -> {
    		UsbCamera cam0 = new UsbCamera("USB Camera 0",0);
    		cam0.setResolution(RobotMap.cameraWidth, RobotMap.cameraHeigth);
    		cam0.setFPS(RobotMap.cameraFR);
    		UsbCamera cam1 = new UsbCamera("USB Camera 1",1);
    		cam1.setResolution(RobotMap.cameraWidth, RobotMap.cameraHeigth);
    		cam1.setFPS(RobotMap.cameraFR);
    		
    		CvSink cvSink = CameraServer.getInstance().getVideo(cam0);
    		CvSource cvSource = CameraServer.getInstance().putVideo("Current View", 640, 480);
    		Mat image = new Mat();
    		
    		while(!Thread.interrupted()) {
    			if (cvSink.grabFrame(image) == 0) {
    				// Send the output the error.
    				cvSource.notifyError(cvSink.getError());
    				// skip the rest of the current iteration
    				continue;
    			}
            	
	                if(RobotMap.shootCameraSelected){	                	
	                	cvSink.setSource(cam0);
	                } else{
	                	cvSink.setSource(cam1);   
	                }
                
                Imgproc.line(image, new Point(0,RobotMap.cameraHeigth/2), new Point(RobotMap.cameraWidth,RobotMap.cameraHeigth/2),new Scalar(255, 255, 255),5);
                Imgproc.line(image, new Point(RobotMap.cameraWidth/2,0), new Point(RobotMap.cameraWidth/2,RobotMap.cameraHeigth),new Scalar(255, 0, 0),5);
                cvSource.putFrame(image);
            }
		});
    	visionThread.setDaemon(true);
		visionThread.start();
    }
    
    public void changeCam(){
    
    	RobotMap.shootCameraSelected = !RobotMap.shootCameraSelected;    	
    }
    
    public void log(){
    	SmartDashboard.putBoolean("Shooter Camera Selected", RobotMap.shootCameraSelected);
    }
}

