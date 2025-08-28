// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

public class Robot extends TimedRobot {
  VictorSPX motorRight1;
  TalonSRX motorRight2;
  VictorSPX motorLeft1;
  VictorSPX motorLeft2;
  XboxController driverController;

  public Robot() {
    motorRight1 = new VictorSPX(0);
    motorRight2 = new TalonSRX(1);
    motorLeft1 = new VictorSPX(2);
    motorLeft2 = new VictorSPX(3);
    driverController = new XboxController(0);
  }

  public double getJoystickValuesWithDeadZoneY(){
    if(driverController.getLeftY() <= 0.2 && driverController.getLeftY() >= -0.2){
      return 0;
    } else {
      return driverController.getLeftY() * 0.3;
    }
  }

  public double getJoystickValuesWithDeadZoneX(){
    if(driverController.getRightX() <= 0.2 && driverController.getRightX() >= -0.2){
      return 0;
    } else {
      return driverController.getRightX() * 0.3;
    }
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
    motorRight2.set(TalonSRXControlMode.PercentOutput, motorRight1.getMotorOutputVoltage());
    motorLeft2.set(VictorSPXControlMode.PercentOutput, motorLeft1.getMotorOutputVoltage());

    motorRight1.set(VictorSPXControlMode.PercentOutput, -this.getJoystickValuesWithDeadZoneY() - this.getJoystickValuesWithDeadZoneX());
    motorLeft1.set(VictorSPXControlMode.PercentOutput, this.getJoystickValuesWithDeadZoneY() - this.getJoystickValuesWithDeadZoneX());
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
