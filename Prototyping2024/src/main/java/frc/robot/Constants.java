// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix6.signals.NeutralModeValue;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
public static final class Shooter{
  public static final int ShooterMotor1 = 1;
  public static final int ShooterMotor2 = 2;

  public static final NeutralModeValue sm1NeutralMode = NeutralModeValue.Brake;
  public static final NeutralModeValue sm2NeutralMode = NeutralModeValue.Brake;

  public static boolean sm1InvertMode = true;
  public static boolean sm2InvertMode = true;
}

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 2;
    public static final int mDriverControllerPort = 0;
    public static final int cDriverControllerPort = 1;
  }
}
