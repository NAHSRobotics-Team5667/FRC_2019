/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.elevator.ElevatorConstants;
import frc.robot.subsystems.elevator.ElevatorSubsystem;
import frc.robot.utils.PIDFController;

public class ElevatorCommand extends CommandBase {

  private PIDFController pidfController = new PIDFController("Elevator", 3.5, 0, 0, .1);
  private ElevatorSubsystem Elevator;

  /**
   * Creates a new ElevatorCommand.
   */
  public ElevatorCommand(ElevatorSubsystem Elevator) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Elevator);
    this.Elevator = Elevator;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Elevator.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Manual Elevator drive
    if (RobotContainer.getController().getRightTrigger() != 0) {
      Elevator.setDriveMode(ElevatorConstants.DriveModes.MANUAL);
      Elevator.driveElevatorByDirection(ElevatorConstants.ElevatorDirection.UP);

    } else if (RobotContainer.getController().getLeftTrigger() != 0) {
      Elevator.setDriveMode(ElevatorConstants.DriveModes.MANUAL);
      Elevator.driveElevatorByDirection(ElevatorConstants.ElevatorDirection.DOWN);

    } else { // Auto PID Elevator drive

      if (RobotContainer.getController().getRightBumperPressed()) {
        Elevator.setDriveMode(ElevatorConstants.DriveModes.AUTO);
        Elevator.increaseLevel();
        pidfController.setSetPoint(Elevator.getHeightFromLevel(Elevator.getCurrentLevel()));

      } else if (RobotContainer.getController().getLeftBumperPressed()) {
        Elevator.setDriveMode(ElevatorConstants.DriveModes.AUTO);
        Elevator.decreaseLevel();
        pidfController.setSetPoint(Elevator.getHeightFromLevel(Elevator.getCurrentLevel()));

      } else if (Elevator.getDriveMode() == ElevatorConstants.DriveModes.MANUAL) {
        Elevator.stop();

      } else {
        Elevator.driveElevatorBySpeed(pidfController.calculate(Elevator.getCurrentHeight()));
      }
    }

    if (RobotContainer.getController().getXButtonPressed()) {
      Elevator.setDriveMode(ElevatorConstants.DriveModes.MANUAL);
      Elevator.stop();
      Elevator.resetEncoder();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Elevator.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
