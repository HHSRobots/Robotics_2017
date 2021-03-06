package org.usfirst.frc.team554.robot.commands;

import org.usfirst.frc.team554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_002 extends CommandGroup {

    public Autonomous_002() {
    	addParallel(new Shooter_Start(RobotMap.shotSetPoint1));
    	addSequential(new TimeDelay(3.0));
    	addSequential(new Shooter_FeederStart());
    	addParallel(new Agitator_Start());
    	addParallel(new Collector_Start(RobotMap.collectSetShoot));
    	addSequential(new TimeDelay(10.0));
    	addSequential(new ShootSequenceStop());

    }
}
