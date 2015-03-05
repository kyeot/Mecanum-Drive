package org.usfirst.frc.team2783.robot.commands;

import org.usfirst.frc.team2783.robot.OI;
import org.usfirst.frc.team2783.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveClamper extends Command {

    public DriveClamper() {
        // Use requires() here to declare subsystem dependencies
    	// eg. requires(chassis);
    	requires(Robot.clamper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double speed;
    	
    	//Combine the left and right triggers to create a -1 to 1 speed value for the clamper
    	speed = (-OI.manipulatorJoystick.getRawAxis(2)) + OI.manipulatorJoystick.getRawAxis(3);
    	
    	//Pass the speed to to the clamper subsystem
    	Robot.clamper.setClamperSpeed(-speed);
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
