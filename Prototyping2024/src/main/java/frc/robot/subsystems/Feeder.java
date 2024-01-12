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
    S_BallEnters, S_BallLeaves
  }
  public void RunFeederState(){
    switch (mFeederEnumState) {
      case S_BallEnters:
      BallEnters();
        break;
      
        default:
        break;
    }
  }

  public void BallEnters(){

    
  }
  public void BallLeaves(){

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
