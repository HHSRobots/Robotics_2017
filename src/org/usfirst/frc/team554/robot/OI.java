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
	
	// Logitech Controller( Driver)
		
	    Joystick driverController = new Joystick(0);
	    Button driverButton1 = new JoystickButton(driverController,1);
	    Button driverButton2 = new JoystickButton(driverController,2);
	    Button driverButton3 = new JoystickButton(driverController,3);
	    Button driverButton4 = new JoystickButton(driverController,4);
	    Button driverButton5 = new JoystickButton(driverController,5);
	    Button driverButton6 = new JoystickButton(driverController,6);
	    Button driverButton7 = new JoystickButton(driverController,7);
	    Button driverButton8 = new JoystickButton(driverController,8);
	    Button driverButton9 = new JoystickButton(driverController,9);
	    Button driverButton10 = new JoystickButton(driverController,10);
	
    // Xbox Controller
	    //Fix assignments when get button lay out.
		Joystick operatorController = new Joystick(1);
		Button A = new JoystickButton(operatorController, 1);
		Button B = new JoystickButton(operatorController, 2);
		Button X = new JoystickButton(operatorController, 3);
	    Button Y = new JoystickButton(operatorController, 4);
	    Button LB = new JoystickButton(operatorController, 5);
		Button RB = new JoystickButton(operatorController, 6);
	    //BeaterBarShootTrigger BBShootButton = new BeaterBarShootTrigger(operatorController);
	    //BeaterBarCollectTrigger BBCollectButton = new BeaterBarCollectTrigger(operatorController);
	    //ArmMoveWithJoystickTrigger MoveArmWithJoystickButton = new ArmMoveWithJoystickTrigger(operatorController);

	    //Both of the triggers need to be set as their relative axis
		Button LTrigger = new JoystickButton(operatorController, 7);
		Button RTrigger = new JoystickButton(operatorController, 8);
	    Button LStickButton = new JoystickButton(operatorController, 9);
	    Button RStickButton = new JoystickButton(operatorController,10);
	
	public Joystick getDriver(){
		return driverController;
	}
	
	public Joystick getXboxController(){
		return operatorController;
	}
	
	public OI(){
		
		//Driver Controller
		driverButton6.whenPressed(new DriveTrain_EngageHighGear());
		driverButton5.whenPressed(new DriveTrain_EngageLowGear());
		driverButton8.whenPressed(new Camera_switch());
		
		//Operator Controller
		RB.whileHeld(new Climb_climbRope());
		LB.whenPressed(new Agitator_Toggle());
		
		A.whenPressed(new Collector_In());
		B.whenPressed(new Collector_Stop());
		Y.whenPressed(new Gear_BoxMove());
		
		
		
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
