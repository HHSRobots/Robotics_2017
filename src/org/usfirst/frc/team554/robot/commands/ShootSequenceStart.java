package org.usfirst.frc.team554.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShootSequenceStart extends CommandGroup {
	
	//private double setpoint;
    public ShootSequenceStart(double setpoint) {
    	
    	addParallel(new Shooter_Start(setpoint));
    	addSequential(new TimeDelay(4.0));
    	addSequential(new Shooter_FeederStart());
    	addParallel(new Agitator_Start());
    	addParallel(new Collector_Shoot());
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
