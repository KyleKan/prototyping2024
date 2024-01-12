// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Feeder extends SubsystemBase {
  private TalonFX FeederMotor;
  public FeederEnumState mFeederEnumState;
  /** Creates a new Feeder. */
  public enum FeederEnumState{
    S_BallEntersFeeder, S_BallLeavesFeeder
  }
  
  public void RunFeederState(){
    switch (mFeederEnumState) {
      case S_BallEntersFeeder:
      BallEntersFeeder();
        break;
    
      case S_BallLeavesFeeder:
      BallLeavesFeeder();
        break;
    }
  }

  public void BallEntersFeeder(){
    mFeederEnumState = FeederEnumState.S_BallEntersFeeder;
  }
  public void BallLeavesFeeder(){

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
