// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends SubsystemBase {

  private TalonFX ShooterLeft;
  private TalonFX ShooterRight;

  /** Creates a new Shooter. */
  public Shooter() {

    ShooterLeft = new TalonFX(Constants.ShooterConstants.ShooterMotorLeft);
    ShooterRight = new TalonFX(Constants.ShooterConstants.ShooterMotorRight);

  }

  public void setSpeedLeft(double speed){
    ShooterLeft.set(speed);
  }
  
  public void setSpeedRight(double speed){
    ShooterRight.set(speed);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("rpmLeft", ShooterLeft.getVelocity().getValueAsDouble()*60);
    SmartDashboard.putNumber("rpmRight", ShooterRight.getVelocity().getValueAsDouble()*60);
    // This method will be called once per scheduler run
  }
}
