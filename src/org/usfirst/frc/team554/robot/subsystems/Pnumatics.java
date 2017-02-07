package org.usfirst.frc.team554.robot.subsystems;

import org.usfirst.frc.team554.robot.Robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pnumatics extends Subsystem {
	
	Compressor compressor;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Pnumatics(){
		if(Robot.isReal()){
			compressor = new Compressor();
		}
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void start(){
    	if(Robot.isReal()){
    		compressor.start();
    	}
    }
}

