
package org.usfirst.frc.team554.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team554.robot.commands.Autonomous_001;
import org.usfirst.frc.team554.robot.commands.Autonomous_002;
import org.usfirst.frc.team554.robot.commands.Autonomous_003;
//import org.usfirst.frc.team554.robot.commands.*;
import org.usfirst.frc.team554.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Shooter shooter = new Shooter();
	public static final Collector collector = new Collector();
	public static final Camera camera = new Camera();
	public static final Agitator agitator =new Agitator();
	public static final PDP pdp = new PDP();
	public static final Pnumatics pnumatics = new Pnumatics();
	public static final Gear gear = new Gear();
	public static final Climb climb = new Climb();
	public static final ThumbWheel thumbwheel = new ThumbWheel();
	
	public int autoProgramNumber;
	
	Preferences prefs;
	
	

	

	Command autonomousCommand;
	//SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		prefs = Preferences.getInstance();
		
		pnumatics.start();
		
		//Camera Defaults
		RobotMap.shootCameraSelected = true;
		camera.startVisionThread();
		
		
		RobotMap.ClimbComplete = false;
		
		driveTrain.resetEncoder();
		shooter.ResetEncoder();
		gear.gearDeliveryPiston();
		
		/*chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		log();
		*/
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		//autonomousCommand = chooser.getSelected();
		autoProgramNumber = thumbwheel.getThumbWheelval();
		
		RobotMap.autoDistance = prefs.getDouble("autoDistance", -40.0);
		RobotMap.autoSpeed = prefs.getDouble("autoSpeed", -0.75);
		
		switch (autoProgramNumber) {
		case 1: autonomousCommand =	new Autonomous_001();
			break;
		case 2: autonomousCommand =	new Autonomous_002();
			break;
		case 3: autonomousCommand =	new Autonomous_003();
		break;
		default: ;//do nothing
		};

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		driveTrain.resetDriveGyro();
		driveTrain.resetEncoder();
		
    	if (autonomousCommand != null) autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		RobotMap.ClimbComplete = false;
		RobotMap.shotPidKp = prefs.getDouble("ShooterKp", 0.0008);
		RobotMap.shotPidKi = prefs.getDouble("ShooterKi", 0.0019);
		RobotMap.shotPidKd = prefs.getDouble("ShooterKd", 0.0);
		
		RobotMap.shotSetPoint1 = prefs.getDouble("ShooterSetPoint1", 2500);
		RobotMap.shotSetPoint2= prefs.getDouble("ShooterSetPoint2", 3000);
		RobotMap.feederSpeed = prefs.getDouble("FeederSpeed", 1.0);
		RobotMap.agitator1Speed = prefs.getDouble("Agitator1Speed", 1.0);
		RobotMap.agitator2Speed = prefs.getDouble("Agitator2Speed", 1.0);
		
		RobotMap.clmbCurrLimit = prefs.getDouble("ClimbCurrentLimit", 30.0);
		RobotMap.clmbSpeed = prefs.getDouble("ClimbSpeed", 1.0);
		
		RobotMap.DistanceToSlowDown = prefs.getDouble("DistanceSlowDown", 20.0);
		
		RobotMap.collectSetIn = prefs.getDouble("PickupCollect",0.75);
		RobotMap.collectSetShoot = prefs.getDouble("PickupShoot", 0.4);
		
		driveTrain.resetEncoder();
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		if(pdp.channelCurrent(RobotMap.clmbPDPch) > RobotMap.clmbCurrLimit){
			RobotMap.ClimbComplete = true;
		}
		log();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	private void log(){
		agitator.log();
		collector.log();
		shooter.log();
		driveTrain.log();
		camera.log();
		pdp.log();
		climb.log();
		gear.log();
		thumbwheel.log();
		SmartDashboard.putBoolean("Climb Complete", RobotMap.ClimbComplete);
	}
}
