/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4738.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Spark;
import wrapper.Drive;
import wrapper.Gamepad;
import wrapper.XboxController;

public class Robot extends IterativeRobot {
	Drive drive;
	Spark flywheel = new Spark(1);
	Spark angler = new Spark(2);
	XboxController XCont = new XboxController(1);
	Gamepad joyStick = new Gamepad(0);
	Solenoid frizbeeFire;
	Compressor compressor;
	boolean flywheelStart = false;

	@Override
	public void robotInit() {
		frizbeeFire = new Solenoid(0);
		drive = new Drive(0, 3);
		compressor = new Compressor(0);
		// compressor.setClosedLoopControl(true);
	}

	@Override
	public void autonomousInit() {
	}

	@Override
	public void autonomousPeriodic() {
	}

	@Override
	public void teleopPeriodic() {
		double flywheelInput = 0;
		if (!flywheelStart) {
			if (joyStick.getButton(4)) {
				flywheelStart = true;
			}
		}
		//joyStick.getToggle(1);
	//	System.out.println(joyStick.getLengthOfTheButtonArray()?"yee":"nay");
		if (flywheelStart) {
			flywheelInput = (joyStick.getAxis(3) - 1) / -2;
		}
		drive.linearArcade(XCont.getAxis(4), XCont.getAxis(1));
		flywheel.set(flywheelInput);
		angler.set(-0.25 * joyStick.getAxis(1));
		frizbeeFire.set(joyStick.getButton(0));
	}

	@Override
	public void testPeriodic() {
	}
}