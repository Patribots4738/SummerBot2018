/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4738.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import wrapper.Drive;
import wrapper.Gamepad;
import wrapper.XboxController;


public class Robot extends IterativeRobot {
	Drive drive;
	Climber flywheel = new Climber(1);
	Climber angler = new Climber(2);
	XboxController XCont = new XboxController(1);
	Gamepad joyStick = new Gamepad(0);
	Solenoid frizbeeFire;
	Compressor compressor;
	@Override
	public void robotInit() {
		frizbeeFire = new Solenoid(0);
		drive = new Drive(0,3);
		compressor = new Compressor(0);
		//compressor.setClosedLoopControl(true);
	}
	@Override
	public void autonomousInit() {
	
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		double flywheelInput = 0;
		
		if(joyStick.getToggle(4)){
			flywheelInput = (joyStick.getAxis(3) -1) / -2 ;
		}
		drive.linearArcade(XCont.getAxis(4), XCont.getAxis(1));
		flywheel.set(flywheelInput);
		angler.set(-1 * joyStick.getAxis(1));
		frizbeeFire.set(joyStick.getButton(0));
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
