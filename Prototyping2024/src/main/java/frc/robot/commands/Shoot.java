// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FlyWheel;

public class Shoot extends Command {

  private FlyWheel mShooter;
  private DoubleSupplier MotorSpeed1;
  private DoubleSupplier MotorSpeed2;


  /** Creates a new Shoot. */
  public Shoot(FlyWheel mShooter, DoubleSupplier MotorSpeed1, DoubleSupplier MotorSpeed2) {
    this.mShooter = mShooter;
    this.MotorSpeed1 = MotorSpeed1;
    this.MotorSpeed2 = MotorSpeed2;

    addRequirements(mShooter);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    mShooter.SetPercentOutput1(MotorSpeed1. getAsDouble());
    mShooter.SetPercentOutput2(MotorSpeed2. getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    mShooter.SetPercentOutput1(0);
    mShooter.SetPercentOutput2(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
