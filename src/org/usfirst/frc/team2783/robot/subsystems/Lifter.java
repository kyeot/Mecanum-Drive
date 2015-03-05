package org.usfirst.frc.team2783.robot.subsystems;

import org.usfirst.frc.team2783.robot.RobotMap;
import org.usfirst.frc.team2783.robot.commands.DriveLifter;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lifter extends Subsystem {
    
    CANTalon lifterTalon = new CANTalon(RobotMap.lifterMotorId);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveLifter());
    }
    
    public void setLifterSpeed(double speed) {
    	lifterTalon.set(speed);
    }
    
    public boolean isFwdLimitClosed() {
    	return lifterTalon.isFwdLimitSwitchClosed();
    }
    
    public boolean isRevLimitClosed() {
    	return lifterTalon.isRevLimitSwitchClosed();
    }
}

