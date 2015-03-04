package org.usfirst.frc.team2783.robot.subsystems;

import org.usfirst.frc.team2783.robot.RobotMap;
import org.usfirst.frc.team2783.robot.commands.DriveLifter;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lifter extends Subsystem {
    
    TalonSRX lifterTalon = new TalonSRX(RobotMap.lifterMotorId);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveLifter());
    }
    
    public void setLifterSpeed(double speed) {
    	lifterTalon.set(speed);
    }
}

