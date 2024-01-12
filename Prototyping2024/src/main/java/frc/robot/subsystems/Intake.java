// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.subsystems.Feeder.FeederEnumState;

public class Intake extends SubsystemBase {
  private TalonFX IntakeM1;
  private TalonFX IntakeM2;
  private Feeder mFeeder;
  
  public IntakeState mIntakeState;

  public enum IntakeState{
    S_WaitingForBall, S_WaitingForShooter
  };
  
  /** Creates a new Intake. */
  
  public Intake() {
  
    IntakeM1 = new TalonFX(Constants.IntakeConstants.IntakeMotor1);
    IntakeM2 = new TalonFX(Constants.IntakeConstants.IntakeMotor2);
    mFeeder = new Feeder();

    mIntakeState = IntakeState.S_WaitingForBall;
  }

  public void RunIntakeState(){
    switch(mIntakeState){
        case S_WaitingForBall:
        WaitingForBall();
        break;
        case S_WaitingForShooter:
        WaitingForShooter();
        break;
    }
  }
  
  public void WaitingForBall(){
    IntakeM1.set(0.1);
    IntakeM2.set(0.1);
    if(IntakeM1.bannersensor() == true)
    {
      mFeeder.mFeederEnumState = FeederEnumState.S_BallEntersFeeder;
      mIntakeState = IntakeState.S_WaitingForShooter;
    }
  }

  public void WaitingForShooter(){
    IntakeM1.set(0);
    intakeM2.set(0);
  }
  
  public void SETSpeed(double MotorSpeed){
    IntakeM1.set(MotorSpeed);
  }

  public void SETSpeed2(double MotorSpeed){
    IntakeM2.set(MotorSpeed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
