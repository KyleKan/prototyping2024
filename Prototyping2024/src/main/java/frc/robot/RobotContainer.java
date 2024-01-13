// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.ActivateBuddyClimb;
import frc.robot.commands.ActivateElevator;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.BuddyClimb;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Feeder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final Feeder mFeeder = new Feeder();
  private final Elevator mElevator = new Elevator();
  private final BuddyClimb mBuddyClimb = new BuddyClimb();
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  
  public final Joystick mDriver = new Joystick(OperatorConstants.kDriverControllerPort);
  public final Joystick mCoDriver = new Joystick(OperatorConstants.kCoDriverControllerPort);

  private final Trigger joystickdriver5 = new Trigger(mDriver.button(5,null));
  private final Trigger joystickdriver6 = new Trigger(mDriver.button(6,null)); 
  private final Trigger joystickdriver4 = new Trigger(mDriver.button(4,null));
  private final Trigger joystickcodriver5 = new Trigger(mCoDriver.button(5,null));
  private final Trigger joystickcodriver3 = new Trigger(mCoDriver.button(3,null));
  private final Trigger joystickcodriver6 = new Trigger(mCoDriver.button(6,null));
  private final Trigger joystickcodriver4 = new Trigger(mCoDriver.button(4,null));

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());

    joystickdriver5.toggleOnTrue(new Shoot(mFeeder));
    joystickdriver6.toggleOnTrue(new ActivateElevator(mElevator,1));
    joystickdriver4.toggleOnTrue(new ActivateElevator(mElevator, -1));
    joystickcodriver5.whileTrue(new ActivateBuddyClimb(mBuddyClimb, 1, mBuddyClimb.BuddyClimbMotorLeft));
    joystickcodriver3.whileTrue(new ActivateBuddyClimb(mBuddyClimb, -1, mBuddyClimb.BuddyClimbMotorLeft));
    joystickcodriver6.whileTrue(new ActivateBuddyClimb(mBuddyClimb, 1, mBuddyClimb.BuddyClimbMotorRight));
    joystickcodriver4.whileTrue(new ActivateBuddyClimb(mBuddyClimb, -1, mBuddyClimb.BuddyClimbMotorRight));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
