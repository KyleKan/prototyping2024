// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BuddyClimb extends SubsystemBase {
  public TalonFX BuddyClimbMotorLeft;
  public TalonFX BuddyClimbMotorRight;
  /** Creates a new BuddyClimb. */
  public BuddyClimb() {
    BuddyClimbMotorLeft = new TalonFX(Constants.BuddyClimbConstants.kBuddyClimbMotorLeft);
    BuddyClimbMotorRight = new TalonFX(Constants.BuddyClimbConstants.kBuddyClimbMotorRight);
  }

  public void MoveBuddyClimb(double speed, TalonFX motor){
    motor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
