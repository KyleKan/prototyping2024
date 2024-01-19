// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class Shoot extends Command {
  private Shooter mShooter;
private DoubleSupplier x;
private DoubleSupplier y;


  /** Creates a new Shoot. */
  public Shoot(Shooter mShooter, DoubleSupplier xs, DoubleSupplier ys){
    this.mShooter = mShooter;
    this.x = xs;
    this.y = ys;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(mShooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mShooter.SetSpeed(x.getAsDouble(),y.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mShooter.SetSpeed(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
