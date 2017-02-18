package org.usfirst.frc.team2783.robot.subsystems;

import org.usfirst.frc.team2783.robot.RobotMap;
import org.usfirst.frc.team2783.robot.commands.DriveClamper;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Clamper extends Subsystem {
    
    CANTalon clamperTalon = new CANTalon(RobotMap.clamperMotorId);
    Encoder clamperEncoder = new Encoder(
    	RobotMap.clamperEncoderChannelA, 
    	RobotMap.clamperEncoderChannelB
    );

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveClamper());
    }
    
    public void setClamperSpeed(double speed) {
    	clamperTalon.set(speed);
    }
    
    public double getEncoderCount() {
    	return clamperEncoder.get();
    }
    
    public double getEncoderRate() {
    	return clamperEncoder.getRate();
    }
    
    public boolean isFwdLimitClosed() {
    	return clamperTalon.isFwdLimitSwitchClosed();
    }
    
    public boolean isRevLimitClosed() {
    	return clamperTalon.isRevLimitSwitchClosed();
    }
}

