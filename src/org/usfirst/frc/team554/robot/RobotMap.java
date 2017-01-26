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
	
	public static int shotMtr = 2; //Shooter Motor PWM Channel
	
	//Solenoids
	public static int gearShiftSolenoid = 0; //Gear Shift Solenoid Channel
	
	//Digital IO / Encoders
	public static int rtDrvEncA = 2; //Right Drive Motor Encoder Channel A
	public static int rtDrvEncB = 3; //Right Drive Motor Encoder Channel B
	public static int ltDrvEncA = 4; //Left Drive Motor Encoder Channel A
	public static int ltDrvEncB = 5; //Left Drive Motor Encoder Channel B
	
	public static int shotEncA = 6; //Shooter motor encoder Channel A
	public static int shotEncB = 7; //Shooter motor encoder Channel B
	
	//Analog / Gyro
	public static int driveGyro = 0; //Gyro Analog Channel 0
	
		
	//Constants
	public static double drvDistPerPulse = 0.0486947*127/134; //Encoder Distance per pulse, TODO edit when wheel size chosen
	public static double shotDistPerPulse = 1/(20.*35/29); //Encoder Distance per pulse, TODO update with final info.
	
	public static double shotPidKp = 0.0008;
	public static double shotPidKi = 0.0019;
	public static double shotPidKd = 0.0;
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
