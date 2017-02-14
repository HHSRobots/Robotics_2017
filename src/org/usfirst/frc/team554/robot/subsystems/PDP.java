package org.usfirst.frc.team554.robot.subsystems;

import org.usfirst.frc.team554.robot.RobotMap;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PDP extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private PowerDistributionPanel pdp;
	
	public PDP(){
    	super();
    	pdp = new PowerDistributionPanel();
    	
    }
	
	public double channelCurrent(int channel){
		return pdp.getCurrent(channel);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void log(){
    	SmartDashboard.putNumber("Climber Amps", channelCurrent(RobotMap.clmbPDPch));
    }
}

