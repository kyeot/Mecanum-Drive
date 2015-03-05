package org.usfirst.frc.team2783.robot.commands;

import org.usfirst.frc.team2783.robot.Robot;

import edu.wpi.first.wpilibj.Utility;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CloseClamper extends Command {
	
	private double closeStartTime;

    public CloseClamper() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.clamper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.closeStartTime = Utility.getFPGATime();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.clamper.setClamperSpeed(-1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	/*If 200 ms have elapsed since the clamper began closing, 
    	 * and the clamper has stopped moving */
    	if (((this.closeStartTime + 200) > Utility.getFPGATime())
    		&& (Robot.clamper.getEncoderRate() < 300)) {
    		return true;
    	} else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.clamper.setClamperSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
