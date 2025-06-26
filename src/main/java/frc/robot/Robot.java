// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

public class Robot extends TimedRobot {

  SparkMax motor1;
  SparkMax motor2;
  XboxController controller;

  public Robot() {
    motor1 = new SparkMax(1, MotorType.kBrushless);
    motor2 = new SparkMax(2, MotorType.kBrushless);
    controller = new XboxController(0);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    if(controller.getAButton()){
      motor1.set(-1);
    } else {
      motor1.set(0);
    }
    
    if (controller.getBButton()){
      motor2.set(-1); 
    } else {
      motor2.set(0);
    }
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
