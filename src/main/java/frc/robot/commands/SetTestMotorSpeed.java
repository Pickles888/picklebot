// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TestMotorSubsystem;

public class SetTestMotorSpeed extends Command {

  private TestMotorSubsystem m_testMotorSubsystem;
  private DoubleSupplier m_speed;

  /** Creates a new SetTestMotorSpeed. */
  public SetTestMotorSpeed(TestMotorSubsystem testMotorSubsystem, DoubleSupplier speed) {
    m_testMotorSubsystem = testMotorSubsystem;
    m_speed = speed;

    addRequirements(m_testMotorSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_testMotorSubsystem.setTestMotorSpeed(m_speed.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_testMotorSubsystem.setTestMotorSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
