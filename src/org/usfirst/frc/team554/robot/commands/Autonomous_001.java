package org.usfirst.frc.team554.robot.commands;

import org.usfirst.frc.team554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_001 extends CommandGroup {

    public Autonomous_001() {
    	
    	addSequential(new DriveTrain_driveSetDistance(RobotMap.autoDistance,RobotMap.autoSpeed));
    }
}
