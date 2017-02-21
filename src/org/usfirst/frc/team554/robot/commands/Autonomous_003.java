package org.usfirst.frc.team554.robot.commands;

import org.usfirst.frc.team554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_003 extends CommandGroup {

    public Autonomous_003() {
    	addParallel(new Shooter_Start(RobotMap.shotSetPoint2));
    	addSequential(new TimeDelay(3.0));
    	addSequential(new Shooter_FeederStart());
    	addParallel(new Agitator_Start());
    	addParallel(new Collector_Start(RobotMap.collectSetShoot));
    	addSequential(new TimeDelay(10.0));
    	addSequential(new ShootSequenceStop());

    }
}
