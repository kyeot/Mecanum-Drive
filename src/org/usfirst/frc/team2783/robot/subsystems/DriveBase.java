package org.usfirst.frc.team2783.robot.subsystems;

import org.usfirst.frc.team2783.robot.RobotMap;
import org.usfirst.frc.team2783.robot.commands.BasicDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveBase extends Subsystem {

	private RobotDrive driveBase = new RobotDrive(
		new TalonSRX(RobotMap.frontLeftMotorId), 
		new TalonSRX(RobotMap.rearLeftMotorId), 
		new TalonSRX(RobotMap.frontRightMotorId), 
		new TalonSRX(RobotMap.rearRightMotorId)
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
    	driveBase.mecanumDrive_Cartesian(x, y, rotation, 0);
    }
}

