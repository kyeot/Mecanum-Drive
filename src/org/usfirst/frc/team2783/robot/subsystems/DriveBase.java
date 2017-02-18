package org.usfirst.frc.team2783.robot.subsystems;

import org.usfirst.frc.team2783.robot.RobotMap;
import org.usfirst.frc.team2783.robot.commands.BasicDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveBase extends Subsystem {

	private RobotDrive driveBase = new RobotDrive(
		new CANTalon(RobotMap.frontLeftMotorId), 
		new CANTalon(RobotMap.rearLeftMotorId), 
		new CANTalon(RobotMap.frontRightMotorId), 
		new CANTalon(RobotMap.rearRightMotorId)
	);
	
	public DriveBase() {
		super();
		this.driveBase.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		this.driveBase.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new BasicDrive());
    }
    
    public void mecanumDrive(double x, double y, double rotation) {
    	driveBase.tankDrive(x, y);
    }
}

