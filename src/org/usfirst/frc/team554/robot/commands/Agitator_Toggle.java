package org.usfirst.frc.team554.robot.commands;

import org.usfirst.frc.team554.robot.Robot;
import org.usfirst.frc.team554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Agitator_Toggle extends Command {

    public Agitator_Toggle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.agitator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if(RobotMap.agitatorOn){
    		Robot.agitator.agitatorMotorSetSpeed(0.0, 0.0);
    		
    	}
    	else{
    		Robot.agitator.agitatorMotorSetSpeed(RobotMap.agitator1Speed, RobotMap.agitator2Speed);
    	}
    	RobotMap.agitatorOn = !RobotMap.agitatorOn;
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
