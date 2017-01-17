package org.usfirst.frc.team554.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	
	//Motors
	public static int rtDrvMtr = 8; //Right Drive Motor PWM Channel
	public static int ltDrvMtr = 9; //Left Drive Motor PWM Channel
	
	//Solenoids
	public static int gearShiftSolenoid = 0; //Gear Shift Solenoid Channel
	
	//Digital IO / Encoders
	public static int rtDrvEncA = 2; //Right Drive Motor Encoder Channel A
	public static int rtDrvEncB = 3; //Right Drive Motor Encoder Channel B
	public static int ltDrvEncA = 4; //Left Drive Motor Encoder Channel A
	public static int ltDrvEncB = 5; //Left Drive Motor Encoder Channel B
	
	//Analog / Gyro
	public static int driveGyro = 0; //Gyro Analog Channel 0
	
	
	

	
	//Constants
	public static double drvDistPerPulse = 0.0486947*127/134; //Encoder Distance per pulse, TODO edit when wheel size chosen
	
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
