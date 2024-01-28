// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class Motor1Spin extends Command {
  private Shooter mShooter;

  /** Creates a new Motor1Spin. */
  public Motor1Spin(Shooter mShooter) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.mShooter = mShooter;
    addRequirements(mShooter);
  }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double SDspeed = SmartDashboard.getNumber("Velocity", 0);
    SmartDashboard.putNumber("getName()", SDspeed);
    mShooter.Motor1Speed(SDspeed);
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
