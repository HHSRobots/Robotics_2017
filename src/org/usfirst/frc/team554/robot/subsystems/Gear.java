package org.usfirst.frc.team554.robot.subsystems;

import org.usfirst.frc.team554.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Gear extends Subsystem {
	
	private Solenoid gearDelivery;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	
	public Gear(){
		super();
		gearDelivery = new Solenoid(RobotMap.gearBoxPosition);
	}
	
	public void gearDeliveryPiston(){
		gearDelivery.set(!gearDelivery.get());
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void log(){
    	SmartDashboard.putBoolean("Gear Delivery", gearDelivery.get());
    }
}

