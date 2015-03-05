package org.usfirst.frc.team2783.robot.commands;

import org.usfirst.frc.team2783.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CenterCamera extends Command {
	
	private double centeredPan = 0.5;
	private double centeredTilt = 0.75;

    public CenterCamera() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.cameraModule);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.cameraModule.setPan(this.centeredPan);
    	Robot.cameraModule.setTilt(this.centeredTilt);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//If the camera is close to being centered, finish the command
        if ((Math.abs(Robot.cameraModule.getPan() - centeredPan) < 0.07) 
        	&& (Math.abs(Robot.cameraModule.getTilt() - centeredTilt) < 0.07)) {
        	return true;
        } else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
