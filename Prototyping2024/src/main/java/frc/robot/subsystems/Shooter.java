// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix6.hardware.TalonFX;

public class Shooter extends SubsystemBase {

  private TalonFX ShooterM1;
  private TalonFX ShooterM2;

  /** Creates a new Shooter. */
  public Shooter() {
    //ShooterM1.setInverted(Constants.Shooter.sm1InvertMode);
    //ShooterM2.setInverted(Constants.Shooter.sm2InvertMode);
    //ShooterM1.setNeutralMode(Constants.Shooter.sm1NeutralMode);
    //ShooterM2.setNeutralMode(Constants.Shooter.sm2NeutralMode);
    ShooterM1 = new TalonFX(Constants.Shooter.ShooterMotor1);
    ShooterM2 = new TalonFX(Constants.Shooter.ShooterMotor2);
  }

  public void SETSpeed(double MotorSpeed) {
    ShooterM1.set(MotorSpeed);

  }

  public void SETSpeed2(double MotorSpeed) {
    ShooterM2.set(MotorSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
      SmartDashboard.putNumber("rpmShooterM1", ShooterM1.getVelocity().getValueAsDouble()*60);
      SmartDashboard.putNumber("rpmShooterM2",60 *  ShooterM2.getVelocity().getValueAsDouble());
  }
}
