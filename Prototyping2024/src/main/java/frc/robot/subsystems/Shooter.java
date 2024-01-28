// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.VelocityDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.StatusCode;
import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.*;

public class Shooter extends SubsystemBase {

  
  private TalonFX ShooterM1;
  private TalonFX ShooterM2;
  double sp;

  public final class CtreUtils {


    public static TalonFXConfiguration generateFXDriveMotorConfig() {
      TalonFXConfiguration motorConfig = new TalonFXConfiguration();
  
      motorConfig.Feedback.FeedbackSensorSource = FeedbackSensorSourceValue.RotorSensor;
      motorConfig.Slot0.kV = 0.1185;
      motorConfig.Slot0.kP = 0.24;
      motorConfig.Slot0.kI = 0.0;
      motorConfig.Slot0.kD = 0.0;
  
      motorConfig.Voltage.PeakForwardVoltage = 12;
      motorConfig.Voltage.PeakReverseVoltage = -12;
  
      motorConfig.CurrentLimits.SupplyCurrentLimit = 35;
      motorConfig.CurrentLimits.SupplyCurrentThreshold = 60;
      motorConfig.CurrentLimits.SupplyTimeThreshold = 0.1;
      motorConfig.CurrentLimits.SupplyCurrentLimitEnable = true;
  
      motorConfig.OpenLoopRamps.VoltageOpenLoopRampPeriod = 0.25; // TO
      // DO adjust this later
      motorConfig.ClosedLoopRamps.VoltageClosedLoopRampPeriod = 0.1; // TODO Adjust this later
  
      motorConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
      motorConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
  
      return motorConfig;
    }
}

  /** Creates a new Shooter. */
  public Shooter() {
    //ShooterM1.setInverted(Constants.Shooter.sm1InvertMode);
    //ShooterM2.setInverted(Constants.Shooter.sm2InvertMode);
    //ShooterM1.setNeutralMode(Constants.Shooter.sm1NeutralMode);
    //ShooterM2.setNeutralMode(Constants.Shooter.sm2NeutralMode);
    ShooterM1 = new TalonFX(Constants.ShooterConstants.Shootermotor1);
    ShooterM2 = new TalonFX(Constants.ShooterConstants.Shootermotor2);
    TalonFXConfiguration motorConfig = new TalonFXConfiguration();
    
    motorConfig.OpenLoopRamps.VoltageOpenLoopRampPeriod = 0.5;

    ShooterM2.getConfigurator().apply(motorConfig);
    
    // set slot 0 gains
    var slot0Configs = new Slot0Configs();
    slot0Configs.kV = 0.0115;
    slot0Configs.kP = 0.03;
    slot0Configs.kI = 0.0;
    slot0Configs.kD = 0.001;
    // apply gains, 50 ms total timeout
    ShooterM2.getConfigurator().apply(slot0Configs, 0.050);

    ShooterM1.setControl(new Follower(ShooterM2.getDeviceID(), true));
  
  }

  public void SetSpeed(double MotorSpeed1, double MotorSpeed2) {
    ShooterM1.set(MotorSpeed1);
    ShooterM2.set(MotorSpeed2);
  }

  public void Motor1Speed(double MotorSpeed) {
    VelocityDutyCycle speed = new VelocityDutyCycle(-MotorSpeed );
    this.sp = speed.Velocity;
    ShooterM2.setControl(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
      SmartDashboard.putNumber("sp", sp);
      SmartDashboard.putNumber("ap", -ShooterM2.getVelocity().getValueAsDouble()); 
      SmartDashboard.putNumber("pp", -ShooterM2.getVelocity().getValueAsDouble());
      //SmartDashboard.putNumber("rpmShooterM1", ShooterM1.getVelocity().getValueAsDouble() * 60 * (64/26));
      //SmartDashboard.putNumber("rpmShooterM2", 60 *  ShooterM2.getVelocity().getValueAsDouble() *  (64/26));
  }
}
