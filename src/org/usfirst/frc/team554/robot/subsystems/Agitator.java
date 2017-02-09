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
	
	private SpeedController AgitatorMotor1;
	private SpeedController AgitatorMotor2;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Agitator(){
    	super();
    	AgitatorMotor1 = new Talon(RobotMap.agidMtr1);
    	AgitatorMotor1.setInverted(false);
    	
    	AgitatorMotor2 =new Talon(RobotMap.agidMtr2);
    	AgitatorMotor2.setInverted(false);
    }
    
    public void agitatorMotorSetSpeed(double setpoint1, double setpoint2){
    	AgitatorMotor1.set(setpoint1);
    	AgitatorMotor2.set(setpoint2);
    	
    }
    
    public void log(){
    	SmartDashboard.putBoolean("AgitatorMotor 1", (AgitatorMotor1.get()!=0));
    	SmartDashboard.putBoolean("AgitatorMotor 2", (AgitatorMotor2.get()!=0));
    }
}

