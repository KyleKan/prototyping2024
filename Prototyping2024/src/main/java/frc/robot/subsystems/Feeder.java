// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter.ShooterState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Feeder extends SubsystemBase {
  private TalonFX FeederMotor;
  public FeederEnumState mFeederEnumState;
  private Shooter mShooter;
  /** Creates a new Feeder. */

  public enum FeederEnumState{
    S_WaitingOnIntake, S_DriverIsReady
  }

  public Feeder(){
    mShooter = new Shooter();
    FeederMotor = new TalonFX(Constants.FeederConstants.kFeederMotor);

    mFeederEnumState = FeederEnumState.S_WaitingOnIntake;
  }
  
  public void RunFeederState(){
    switch (mFeederEnumState) {
      case S_WaitingOnIntake:
        FeederMotor.stopMotor();
        break;
      case S_DriverIsReady:
      DriverIsReady(mShooter);
        break;
    }
  }

  public void DriverIsReady(Shooter mShooter){
    mShooter.mShooterState = ShooterState.S_Shoot;
    if(mShooter.ShooterLeft.getVelocity().getValueAsDouble() == 1){
      FeederMotor.set(0.1);
    }
  }
  @Override
  public void periodic() {
    RunFeederState();
    // This method will be called once per scheduler run
  }
}
