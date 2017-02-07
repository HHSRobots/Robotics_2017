package org.usfirst.frc.team554.robot.subsystems;

import org.usfirst.frc.team554.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Agitator extends Subsystem {
	
	private SpeedController AgitatorMotor;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Agitator(){
    	super();
    	AgitatorMotor = new Talon(RobotMap.agidMtr);
    	AgitatorMotor.setInverted(false);
    }
    
    public void agitatorMotorSetSpeed(double setpoint){
    	AgitatorMotor.set(setpoint);
    	
    }
    
    public void log(){
    	SmartDashboard.putBoolean("AgitatorMotor", (AgitatorMotor.get()!=0));
    }
}

