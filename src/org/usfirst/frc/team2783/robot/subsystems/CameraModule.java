package org.usfirst.frc.team2783.robot.subsystems;

import org.usfirst.frc.team2783.robot.RobotMap;
import org.usfirst.frc.team2783.robot.commands.DriveCamera;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraModule extends Subsystem {
    
    Servo cameraPanServo = new Servo(RobotMap.cameraPanServoChannel);
    Servo cameraTiltServo = new Servo(RobotMap.cameraTiltServoChannel);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveCamera());
    }
    
    public double getPan() {
    	return cameraPanServo.get();
    }
    
    public double getTilt() {
    	return cameraTiltServo.get();
    }
    
    public void setPan(double position) {
    	cameraPanServo.set(position);
    }
    
    public void setTilt(double position) {
    	cameraTiltServo.set(position);
    }
}

