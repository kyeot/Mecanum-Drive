package org.usfirst.frc.team2783.robot.commands;

import org.usfirst.frc.team2783.robot.OI;
import org.usfirst.frc.team2783.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCamera extends Command {

    public DriveCamera() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.cameraModule);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double camControlXAxis = OI.manipulatorJoystick.getRawAxis(4);
    	double camControlYAxis = OI.manipulatorJoystick.getRawAxis(5);
    	
    	//If joystick isn't centered, change the position of the camera
    	if (Math.abs(camControlXAxis) > 0.1) {
    		double newXPosition = Robot.cameraModule.getPan() + (camControlXAxis / 125);
    		Robot.cameraModule.setPan(newXPosition);
    	}
    	if (Math.abs(camControlYAxis) > 0.1) {
    		double newYPosition = Robot.cameraModule.getTilt() + (camControlYAxis / 125);
    		Robot.cameraModule.setPan(newYPosition);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
