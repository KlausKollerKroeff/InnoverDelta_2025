// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class Robot extends TimedRobot {

  VictorSP motorRight1;
  VictorSP motorRight2;
  VictorSP motorLeft1;
  VictorSP motorLeft2;
  XboxController driverController;

  public Robot() {
    motorRight1 = new VictorSP(0);
    motorRight2 = new VictorSP(1);
    motorLeft1 = new VictorSP(2);
    motorLeft2 = new VictorSP(3);
    driverController = new XboxController(0);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    motorRight2.set(motorRight1.get());
    motorLeft2.set(motorLeft1.get());

    motorRight1.set(driverController.getLeftY() - driverController.getLeftX());
    motorLeft1.set(-driverController.getLeftY() - driverController.getLeftX());
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
