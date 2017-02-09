package org.usfirst.frc.team554.robot.subsystems;

import org.usfirst.frc.team554.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Climb extends Subsystem {

    private SpeedController ClimbMotor;
    
    
    public Climb(){
    	ClimbMotor = new Talon(RobotMap.clmbMtr);
    	ClimbMotor.setInverted(false);
    }
    
    public void climbMotorSetSpeed(double setpoint){
    	ClimbMotor.set(setpoint);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void log(){
    	SmartDashboard.putBoolean("Climb Motor On", ClimbMotor.get()!=0);
    }
}

