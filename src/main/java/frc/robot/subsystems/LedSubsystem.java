// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.CANdleConfiguration;

import java.util.HashMap;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import com.ctre.phoenix.led.Animation;
import com.ctre.phoenix.led.ColorFlowAnimation;

public class LedSubsystem extends SubsystemBase {

  private CANdle m_leds = new CANdle(0);

  Optional<Alliance> m_alliance = DriverStation.getAlliance();

  private int[] m_drewGreen = {4, 106, 56};
  private int[] m_frcRed = {237, 28, 36};
  private int[] m_frcBlue = {0, 101, 179};
  private int[] m_frcNull = {153, 153, 154};

  private int[] m_catppuccinGreen = {166, 218, 149};
  private int[] m_catppucinRed = {237, 135, 150};
  private int[] m_catppucinBlue = {138, 173, 244};
  private int[] m_catppucinNull = {202, 211, 245};

  private int[] m_teamColor;
  private int m_whiteAmount = 150;

  private LEDState m_LEDStates;

  /** Creates a new LedSubsystem. */
  public LedSubsystem() {}

  @Override
  public void periodic() {
    if (m_alliance.isPresent()) {
      if (m_alliance.get() == Alliance.Red) {
          m_teamColor = m_frcRed;
      }
      if (m_alliance.get() == Alliance.Blue) {
          m_teamColor = m_frcBlue;
      }
  }
  else {
      m_teamColor = m_frcNull;
  }
  }

  public void flowTeamColor(int animationSlot) {
      m_leds.animate(
        new ColorFlowAnimation(
          m_teamColor[0], 
          m_teamColor[1], 
          m_teamColor[2], 
        ),
        animationSlot
      );
  }

  public void flowDrewGreen(int animationSlot) {
      m_leds.animate(
        new ColorFlowAnimation(
          m_drewGreen[0], 
          m_drewGreen[1], 
          m_drewGreen[2], 
          0.5
        ),
        animationSlot
      );
  }

  public void clearAnimations(int animationSlot1, int animationSlot2) {
    m_leds.clearAnimation(animationSlot1, animationSlot2);
  }

}