package org.usfirst.frc.team554.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_002 extends CommandGroup {

    public Autonomous_002() {
    	addParallel(new Shooter_Start(2500));
    	addSequential(new TimeDelay(3.0));
    	addSequential(new Shooter_FeederStart());
    	addParallel(new Agitator_Start());
    	addParallel(new Collector_Shoot());
    	addSequential(new TimeDelay(10.0));
    	addSequential(new ShootSequenceStop());

    }
}
