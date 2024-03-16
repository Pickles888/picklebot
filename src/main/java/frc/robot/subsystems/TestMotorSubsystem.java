// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class TestMotorSubsystem extends SubsystemBase {
    
  private CANSparkMax m_testMotor = new CANSparkMax(10, MotorType.kBrushless);

  /** Creates a new TestMotor. */
  public TestMotorSubsystem() {}

  @Override
  public void periodic() {}

  public void setTestMotorSpeed(double speed) {
    SmartDashboard.putNumber("TestMotor Speed", speed);
    m_testMotor.set(speed);
  }

}