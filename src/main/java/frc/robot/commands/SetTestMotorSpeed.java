// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.DoubleSupplier;
import frc.robot.subsystems.TestSubsystem;

public class SetTestMotorSpeed extends Command {
  private TestSubsystem m_testSubsystem;
  private DoubleSupplier m_speed;

  /** Creates a new setMotorSpeed. */
  public SetTestMotorSpeed(TestSubsystem testSubsystem, DoubleSupplier speed) {
    m_speed = speed;
    m_testSubsystem = testSubsystem;

    addRequirements(m_testSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_testSubsystem.setTestMotorSpeed(m_speed.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_testSubsystem.setTestMotorSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
