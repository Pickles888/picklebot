// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LedSubsystem;

public class AnimateLed extends Command {

  private LedSubsystem m_ledSubsystem;

  private int animationSlot1 = 1;
  private int animationSlot2 = 2;

  /** Creates a new AnimateLed. */
  public AnimateLed(LedSubsystem ledSubsystem) {
    m_ledSubsystem = ledSubsystem;

    addRequirements(m_ledSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_ledSubsystem.flowTeamColor(animationSlot1);
    m_ledSubsystem.flowDrewGreen(animationSlot2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_ledSubsystem.clearAnimations(animationSlot1, animationSlot2);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
