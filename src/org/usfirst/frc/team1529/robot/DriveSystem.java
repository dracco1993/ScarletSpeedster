/**
 * Drive System:
 * 1 side of our drive system
 * Victors(3)
 * Encoders(1)
 */
package org.usfirst.frc.team1529.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * @author CyberCards
 *
 */
public class DriveSystem {
	VictorSP victor1, victor2, victor3;
	private double direction;
	Encoder encoder;
	/**
	 * Sets up one side of our overall drive system.
	 * @param inverted: sets orientation of motors
	 * @param victorPWMPort1: PWM for VictorSP 1
	 * @param victorPWMPort2: PWM for VictorSP 2
	 * @param victorPWMPort3: PWM for VictorSP 3
	 */
	public DriveSystem(boolean inverted, int victorPWMPort1, int victorPWMPort2, int victorPWMPort3, int channelA, int channelB, boolean reverseDirection) {
		if(inverted)
			direction = -1.0;
		else 
			direction = 1.0;

		victor1 = new VictorSP(victorPWMPort1);
		victor2 = new VictorSP(victorPWMPort2);
		victor3 = new VictorSP(victorPWMPort3);
		encoder = new Encoder(channelA , channelB, reverseDirection);
	}
	
	/**
	 * Sets speed for all Victor SPs
	 * @param speed: speed setting
	 */
	public void setSpeed(double speed) {
		speed = direction * speed;
		victor1.setSpeed(speed);
		victor2.setSpeed(speed);
		victor3.setSpeed(speed);
//		Logger.log(String.format("Setting speed to: %f", speed));
//		Logger.log(String.format("Victor1 speed set to: %f", victor1.getSpeed()));
//		Logger.log(String.format("Victor2 speed set to: %f", victor2.getSpeed()));
//		Logger.log(String.format("Victor3 speed set to: %f", victor3.getSpeed()));
	}
}
