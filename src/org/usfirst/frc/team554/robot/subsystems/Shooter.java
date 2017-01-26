package org.usfirst.frc.team554.robot.subsystems;

import org.usfirst.frc.team554.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private SpeedController ShooterMotor;
	private Encoder ShooterEncoder;
	private PIDController ShooterPID;
	
	public Shooter(){
		super();
		ShooterMotor = new Victor(RobotMap.shotMtr);
		ShooterMotor.setInverted(false);
		ShooterEncoder = new Encoder(RobotMap.shotEncA,RobotMap.shotEncB);
		ShooterEncoder.setDistancePerPulse(RobotMap.shotDistPerPulse);
		
		ShooterEncoder.setPIDSourceType(PIDSourceType.kRate);
		ShooterEncoder.setMaxPeriod(0.5);
		
		ShooterPID = new PIDController(RobotMap.shotPidKp,RobotMap.shotPidKi,RobotMap.shotPidKd,ShooterEncoder,ShooterMotor);
		ShooterPID.setInputRange(0.0,120.0); //set as 7200 rpm or 120rps
		
		
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	public void startShooterMotor(double setpoint){
		ShooterPID.setSetpoint(setpoint/60.); // target setpoint in rpm to rps (encoder rate value)
		SmartDashboard.putNumber("Shooter Setpoint (rpm, value)", ShooterPID.getSetpoint()*60);
		if (ShooterPID.isEnabled() == false){
			ShooterPID.enable();
		}
	}
	
	public void stopShooterMotor(){
		ShooterPID.disable();
	}
	
	public void ResetEncoder(){
		ShooterEncoder.reset();
	}
	
	public void log(){
		SmartDashboard.putNumber("Shooter Cmd", ShooterMotor.get());
		SmartDashboard.putNumber("Shooter Enc Rate (rpm)", ShooterEncoder.getRate()*60);
		SmartDashboard.putNumber("Shooter Error", ShooterPID.getError());
	}
}

