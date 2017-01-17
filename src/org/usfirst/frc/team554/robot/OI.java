package org.usfirst.frc.team554.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	// Joystick: Logitech Controller( Driver)
		
	    Joystick driverJoystick = new Joystick(0);
	    Button trigger = new JoystickButton(driverJoystick,1);
	    Button missleButton = new JoystickButton(driverJoystick,2);
	    Button button3 = new JoystickButton(driverJoystick,3);
	    Button button4 = new JoystickButton(driverJoystick,4);
	    Button button5 = new JoystickButton(driverJoystick,5);
	    Button button6 = new JoystickButton(driverJoystick,6);
	    Button button7 = new JoystickButton(driverJoystick,7);
	    Button button8 = new JoystickButton(driverJoystick,8);
	    Button button9 = new JoystickButton(driverJoystick,9);
	    Button button10 = new JoystickButton(driverJoystick,10);
	
    // Xbox Controller
	    //Fix assignments when get button lay out.
		Joystick xboxController = new Joystick(1);
		Button A = new JoystickButton(xboxController, 1);
		Button B = new JoystickButton(xboxController, 2);
		Button X = new JoystickButton(xboxController, 3);
	    Button Y = new JoystickButton(xboxController, 4);
	    Button LB = new JoystickButton(xboxController, 5);
		Button RB = new JoystickButton(xboxController, 6);
	
	
	public Joystick getDriver(){
		return driverJoystick;
	}
	
	public Joystick getXboxController(){
		return xboxController;
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
