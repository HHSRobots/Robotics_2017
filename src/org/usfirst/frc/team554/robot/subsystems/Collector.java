package org.usfirst.frc.team554.robot.subsystems;

import org.usfirst.frc.team554.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Collector extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private SpeedController CollectorMotor;
	private int colMotorIndicator;
	public Collector(){
		super();
		CollectorMotor = new Talon(RobotMap.collMtr);
		CollectorMotor.setInverted(true);
		colMotorIndicator = 0;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void collectorMotorSetSpeed(double setpoint){
    	CollectorMotor.set(setpoint);
    	
    	if(setpoint > 0.0){
    		colMotorIndicator = 1;
    	}
    	else if(setpoint < 0.0){
    		colMotorIndicator = 2;
    	}
    	else{
    		colMotorIndicator = 0;
    	}
    	
    }
    
    public void log(){
    	SmartDashboard.putNumber("CollectorMotor", colMotorIndicator);
    }
    

}

