// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;
public class FlyWheel extends SubsystemBase {

  private TalonFX Shooter1;
  private TalonFX Shooter2;
  /** Creates a new FlyWheel. */
  public FlyWheel() {

    Shooter1 = new TalonFX(Constants.FlyWheel.ShooterMotor1);
    Shooter2 = new TalonFX(Constants.FlyWheel.ShooterMotor2);
  
    Shooter1.setInverted(Constants.FlyWheel.sm1InvertMode);
    Shooter2.setInverted(Constants.FlyWheel.sm2InvertMode);

    //Shooter1.setNeutralMode(Constants.FlyWheel.sm1NeutralMode);
    //Shooter2.setNeutralMode(Constants.FlyWheel.sm2NeutralMode);
  }

  public void SetPercentOutput1(double Speed) {
    Shooter1.set(Speed);
  }
  public void SetPercentOutput2(double Speed) {
    Shooter2.set(Speed);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("RPM1", 60*Shooter1.getVelocity().getValueAsDouble());
    SmartDashboard.putNumber("RPM2", 60*Shooter2.getVelocity().getValueAsDouble());
    // This method will be called once per scheduler run
  }
}
