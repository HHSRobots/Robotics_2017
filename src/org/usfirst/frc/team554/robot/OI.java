package org.usfirst.frc.team554.robot;

import org.usfirst.frc.team554.robot.commands.*;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	
	
    // Xbox Controller (Driver)
	    //Fix assignments when get button lay out.
		Joystick dController = new Joystick(0);
		Button A = new JoystickButton(dController, 1);
		Button B = new JoystickButton(dController, 2);
		Button X = new JoystickButton(dController, 3);
	    Button Y = new JoystickButton(dController, 4);
	    Button LB = new JoystickButton(dController, 5);
		Button RB = new JoystickButton(dController, 6);
	    
	    //Both of the triggers need to be set as their relative axis
		Button LTrigger = new JoystickButton(dController, 7);
		Button RTrigger = new JoystickButton(dController, 8);
	    Button LStickButton = new JoystickButton(dController, 9);
	    Button RStickButton = new JoystickButton(dController,10);
	    
	    // Logitech Controller( Operator)
		
	    Joystick oController = new Joystick(1);
	    Button oButton1 = new JoystickButton(oController,1);
	    Button oButton2 = new JoystickButton(oController,2);
	    Button oButton3 = new JoystickButton(oController,3);
	    Button oButton4 = new JoystickButton(oController,4);
	    Button oButton5 = new JoystickButton(oController,5);
	    Button oButton6 = new JoystickButton(oController,6);
	    Button oButton7 = new JoystickButton(oController,7);
	    Button oButton8 = new JoystickButton(oController,8);
	    Button oButton9 = new JoystickButton(oController,9);
	    Button oButton10 = new JoystickButton(oController,10);
	
	public Joystick getDriver(){
		return dController;
	}
	
	public Joystick getXboxController(){
		return oController;
	}
	
	public OI(){
		
		//Driver Controller
		RB.whenPressed(new DriveTrain_EngageHighGear());
		LB.whenPressed(new DriveTrain_EngageLowGear());
		A.whenPressed(new Camera_switch());
		
		//Operator Controller
		oButton5.whileHeld(new Climb_climbRope());
		
		oButton2.whenPressed(new CollectSequenceStart());
		oButton3.whenPressed(new CollectSequenceStop());
		
		oButton8.whenPressed(new ShootSequenceStart());
		oButton7.whenPressed(new ShootSequenceStop());
		
		oButton4.whenPressed(new Shooter_Start());
		oButton6.whenPressed(new Shooter_Stop());
		
		
	}
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
