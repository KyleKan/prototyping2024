// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private TalonFX ShooterLeft;
  private TalonFX ShooterRight;

  public ShooterState mShooterState;

  public enum ShooterState{
    S_BallEntersShooter, S_Shoot
  };

  /** Creates a new Shooter. */
  public Shooter() {
    ShooterLeft = new TalonFX(Constants.ShooterConstants.kShooterLeft);
    ShooterRight = new TalonFX(Constants.ShooterConstants.kShooterRight);
  }

  public void RunShooterState(){
    switch(mShooterState) {
      case S_BallEntersShooter:
        BallEntersShooter();
        break;
      case S_Shoot:
        Shoot();
        break;
    }
  }

public void BallEntersShooter(){
    mShooterState = ShooterState.S_Shoot;
}

public void Shoot(){

}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
