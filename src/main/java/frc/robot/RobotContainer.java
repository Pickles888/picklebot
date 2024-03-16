// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.SetTestMotorSpeed;
import frc.robot.subsystems.TestMotorSubsystem;

public class RobotContainer {

  private CommandXboxController m_controller = new  CommandXboxController(0);
  public TestMotorSubsystem m_testMotorSubsystem = new TestMotorSubsystem();
  

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    m_testMotorSubsystem.setDefaultCommand(
      new SetTestMotorSpeed(
        m_testMotorSubsystem,
        () -> (m_controller.getRightTriggerAxis() - m_controller.getLeftTriggerAxis()) / 2
      )
    );
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
