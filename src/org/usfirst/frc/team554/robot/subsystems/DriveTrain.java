package org.usfirst.frc.team554.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team554.robot.RobotMap;

/**
 *
 */
public class DriveTrain extends Subsystem {

	private SpeedController leftDriveWheels, rightDriveWheels;
	private Encoder leftDriveEncoder, rightDriveEncoder;
	private RobotDrive drive;
	private AnalogGyro driveGyro;
    private Solenoid gearShift;
        
    public DriveTrain(){
    	super();
    	leftDriveWheels = new VictorSP(RobotMap.ltDrvMtr);
    	rightDriveWheels = new VictorSP(RobotMap.rtDrvMtr);
    	drive = new RobotDrive(leftDriveWheels, rightDriveWheels);
    	drive.setSafetyEnabled(false);    	
    	leftDriveEncoder = new Encoder(RobotMap.ltDrvEncA,RobotMap.ltDrvEncB);
    	leftDriveEncoder.setDistancePerPulse(RobotMap.drvDistPerPulse);
    	rightDriveEncoder = new Encoder(RobotMap.rtDrvEncA,RobotMap.rtDrvEncB);    	
    	rightDriveEncoder.setDistancePerPulse(RobotMap.drvDistPerPulse);
    	gearShift = new Solenoid(RobotMap.gearShiftSolenoid);
    	driveGyro =new AnalogGyro(RobotMap.driveGyro);
    	
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void driveJoystick(Joystick drive_Joystick){
    	drive.arcadeDrive(drive_Joystick, true);
    }
    
    public void driveManual(double rightSpeed, double leftSpeed){
    	leftDriveWheels.set(leftSpeed);
    	rightDriveWheels.set(rightSpeed);
    }
    
    public void driveAutomaticStraight(double speed, double distance){
    	resetEncoder();
    	if ( Math.abs( speed) > 0.4 ){
    		if ( (distance - getDriveDistance()) <= RobotMap.DistanceToSlowDown && (distance - getDriveDistance()) > 0 ){
    			speed = ((speed - 0.4) / 20 * (distance - getDriveDistance()) + 0.4);
    		}
    		else if ( (getDriveDistance()- distance ) <= RobotMap.DistanceToSlowDown && (getDriveDistance()- distance) > 0 ){
    			speed =  -1*((speed - 0.4) / 20 * (distance - getDriveDistance()) + 0.4);
    		}
    		
    	}	
    	
    	drive.arcadeDrive(-speed,0);
    }
    
    
    //Get distance driven
    public double getDriveDistance(){
    	return (rightDriveEncoder.getDistance()+leftDriveEncoder.getDistance())/2.0;
    }
	    
    /////////////////////RESET ENCODERS & GYRO/////////////////////////////////
    	//reset Drive Encoders
	    public void resetEncoder(){
	    	leftDriveEncoder.reset();
	    	rightDriveEncoder.reset();
	    }
	    
	    //reset gyro, does not recalibrate
	    public void resetDriveGyro(){
	    	driveGyro.reset();
	    }
	    
	    //initiate and calibrate the gyro. Used during program start.
	    public void calibrateDriveGyro(){
	    	driveGyro.initGyro();
	    	driveGyro.calibrate();
	    }
    
    /////////////////////GEAR SHIFT/////////////////////////////////
	    public void gearShiftHigh(){
	    	if(gearShift.get() != true){
	    		gearShift.set(true);
	    	}
	    }
	    
	    public void gearShiftLow(){
	    	if(gearShift.get() != false){
	    		gearShift.set(false);
	    	}
	    }
    
    /////////////////////WRITE TO DRIVER STATION/////////////////////////////////
	    public void log() {
	        SmartDashboard.putNumber("drive leftmove", leftDriveEncoder.getDistance());
	        SmartDashboard.putNumber("drive rightmove", rightDriveEncoder.getDistance());
	        SmartDashboard.putNumber("drive distance", this.getDriveDistance());
	        SmartDashboard.putBoolean("High Gear", gearShift.get());
	        SmartDashboard.putBoolean("Low Gear", !gearShift.get());
	        SmartDashboard.putNumber("Gyro Rate", driveGyro.getRate());
	        
	    }
    
}

