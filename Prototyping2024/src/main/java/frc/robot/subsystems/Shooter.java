// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix6.controls.VelocityDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Feeder.FeederEnumState;
import frc.robot.subsystems.Intake.IntakeState;

public class Shooter extends SubsystemBase {
  public TalonFX ShooterLeft;
  private TalonFX ShooterRight;

  private Timer mTimer = new Timer();

  public ShooterState mShooterState;
  
  private Feeder mFeeder = new Feeder();
  private Intake mIntake = new Intake();

  public final Joystick mDriver = new Joystick(OperatorConstants.kDriverControllerPort);
  public final Joystick mCoDriver = new Joystick(OperatorConstants.kCoDriverControllerPort);

  public enum ShooterState{
    S_WaitingForFeeder, S_Shoot
  };

  /** Creates a new Shooter. */
  public Shooter() {
    ShooterLeft = new TalonFX(Constants.ShooterConstants.kShooterLeft);
    ShooterRight = new TalonFX(Constants.ShooterConstants.kShooterRight);
    mShooterState = ShooterState.S_WaitingForFeeder;
  }

  public void RunShooterState(){
    switch(mShooterState) {
      case S_WaitingForFeeder:
        ShooterLeft.set(0.5);
        break;
      case S_Shoot:
        Shoot();
        break;
    }
  }

public void Shoot(){
  ShooterLeft.set(DoubleSupplier(mDriver).Velocity);
  ShooterRight.set(DoubleSupplier(mCoDriver).Velocity);
  mTimer.start();
  if(mTimer.hasElapsed(5))
  {
    mIntake.mIntakeState = IntakeState.S_WaitingForBall;
    mFeeder.mFeederEnumState = FeederEnumState.S_WaitingOnIntake;
    mShooterState = ShooterState.S_WaitingForFeeder;
    mTimer.stop();
    mTimer.reset();
  }
}

public VelocityDutyCycle DoubleSupplier(Joystick joystick){
  DoubleSupplier Speed = ()-> (joystick.getThrottle() + 1)/2 * 6380;
  VelocityDutyCycle mSpeed = new VelocityDutyCycle(Speed.getAsDouble());
  return mSpeed;
}

  @Override
  public void periodic() {
    
    RunShooterState();
    SmartDashboard.putNumber("LeftThrottle", DoubleSupplier(mDriver).Velocity);
    SmartDashboard.putNumber("RightThrottle", DoubleSupplier(mCoDriver).Velocity);
    // This method will be called once per scheduler run
  }
}
