package org.usfirst.frc.team2783.robot.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class Dpad extends Trigger {
	
	Joystick joystick;
	int povSelection;
	double povTargetAngle;
    
	public Dpad(Joystick joystick, int povSelection, double povTargetAngle) {
		this.joystick = joystick;
		this.povSelection = povSelection;
		this.povTargetAngle = povTargetAngle;
	}
	
    public boolean get() {
        /*	If the joystick's selected POV is currently reading
    	*	close to the target, return true. Otherwise, return false */
    	if (Math.abs(joystick.getPOV(this.povSelection) - this.povTargetAngle) < 3) {
    		return true;
    	} else {
    		return false;
    	}
    }
}
