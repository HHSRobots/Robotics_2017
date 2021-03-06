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
	public static int rtDrvMtr = 9; //Right Drive Motor PWM Channel
	public static int ltDrvMtr = 7; //Left Drive Motor PWM Channel
	
	public static int shotMtr = 1; //Shooter Motor PWM Channel
	public static int feedMtr = 2; //Feeder Motor PWM Channel
	public static int agidMtr1 = 3; //agitator motor 1 PWM channel
	public static int agidMtr2 = 4; // Agitator motor 2 PWM channel
	public static int clmbMtr = 5; //Climber Motor PWM Channel
	public static int collMtr = 6; //Collector Motor PWM Channel
	
	//Solenoids
	public static int gearShiftSolenoid = 0; //Gear Shift Solenoid Channel
	public static int gearBoxPosition = 1; //Position Solenoid for gear delivery
	
	//Digital IO / Encoders
	public static int rtDrvEncA = 4; //Right Drive Motor Encoder Channel A
	public static int rtDrvEncB = 5; //Right Drive Motor Encoder Channel B
	public static int ltDrvEncA = 2; //Left Drive Motor Encoder Channel A
	public static int ltDrvEncB = 3; //Left Drive Motor Encoder Channel B
	
	public static int shotEncA = 8; //Shooter motor encoder Channel A
	public static int shotEncB = 7; //Shooter motor encoder Channel B
	
	//Analog / Gyro
	public static int driveGyro = 0; //Gyro Analog Channel 0
	
		
	//Constants
	public static double drvDistPerPulseL = (25.5/23.4)*(0.0486947*127/134); 
	public static double drvDistPerPulsR = (25.0/15.0)*(0.0486947*127/134); 
	public static double shotDistPerPulse = 1/(20.*35/29); 
	
	public static double shotPidKp = 0.0008;
	public static double shotPidKi = 0.002;
	public static double shotPidKd = 0.0;
	
	public static double shotSetPoint1 = 2500;
	public static double shotSetPoint2 = 3000;
	public static double shotDelay = 4.0;
	
	
	public static double collectSetIn = .75;
	public static double collectSetShoot = 0.4;
	
	public static int cameraWidth = 320;
	public static int cameraHeigth = 240;
	public static int cameraFR = 30;
	public static boolean shootCameraSelected = true;
	public static boolean shootCameraSelectedPrev = true;
	
	
	public static double feederSpeed = 1.0;
	public static double agitator1Speed = 1.0;
	public static double agitator2Speed = 1.0;
	
	public static boolean agitatorOn = false;
	
	public static int clmbPDPch = 15;
	public static double clmbCurrLimit;
	public static double clmbSpeed;
	public static boolean ClimbComplete = false;
	
	public static double DistanceToSlowDown;
	
	public static double autoSpeed = -0.75;
	public static double autoDistance = -40.0;
	
	
	
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
