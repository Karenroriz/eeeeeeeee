// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.DirectionCommand;
import frc.robot.Subsystem.DriveDirection;
import frc.robot.Subsystem.DriveSpeed;

public class RobotContainer {

  GenericHID driverStick = new GenericHID(0);
  DriveDirection dd = new DriveDirection();
  DriveSpeed ds = new DriveSpeed();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(driverStick, PS5Controller.Button.kL1.value)
                        .whileTrue(new DirectionCommand(() -> driverStick.getRawAxis(4), dd));

  }

  public Command getAutonomousCommand() {
    return Commands.run(dd::updateAbscoder, dd);
  }
}
