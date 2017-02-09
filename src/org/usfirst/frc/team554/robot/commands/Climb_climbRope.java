package org.usfirst.frc.team554.robot.commands;

import org.usfirst.frc.team554.robot.Robot;
import org.usfirst.frc.team554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Climb_climbRope extends Command {

    public Climb_climbRope() {
    	requires(Robot.climb);
    	requires(Robot.pdp);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!RobotMap.ClimbComplete && (Robot.pdp.channelCurrent(RobotMap.clmbPDPch) < RobotMap.clmbCurrLimit)){
    		Robot.climb.climbMotorSetSpeed(RobotMap.clmbSpeed);
    	}
    	else{
    		RobotMap.ClimbComplete = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.ClimbComplete;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.climb.climbMotorSetSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
