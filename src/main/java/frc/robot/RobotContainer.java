// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.SetTestMotorSpeed;
import frc.robot.subsystems.TestSubsystem;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {

  public TestSubsystem m_testSubsystem = new TestSubsystem();
  private CommandXboxController m_controller1 = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    m_testSubsystem.setDefaultCommand(
      new SetTestMotorSpeed(
        m_testSubsystem,
        m_controller1::getRightTriggerAxis
      )
    );
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
