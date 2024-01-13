// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.BuddyClimb;

public class ActivateBuddyClimb extends Command {
  private BuddyClimb mBuddyClimb;
  private double mSpeed; 
  private TalonFX mMotor;
  /** Creates a new ActivateBuddyClimb. */
  public ActivateBuddyClimb(BuddyClimb mBuddyClimb, double Speed, TalonFX motor) {
    this.mBuddyClimb = mBuddyClimb;
    this.mSpeed = Speed;
    this.mMotor = motor;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mBuddyClimb.MoveBuddyClimb(mSpeed, mMotor);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
