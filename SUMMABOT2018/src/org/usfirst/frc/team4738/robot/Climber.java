package org.usfirst.frc.team4738.robot;

import edu.wpi.first.wpilibj.Spark;

public class Climber {
	Spark winch;
	
	public Climber(int port){
		winch = new Spark(port);
}
	
	public void set(double speed){
		/*if (up == true){
			*/winch.set(/*-1*/speed);/*
		}else if (down == true){
			winch.set(1);
		} else {
			winch.set(0);
		}*/
	}
}