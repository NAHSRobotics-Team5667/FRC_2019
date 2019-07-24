# The Digital Eagles Team 5667 2019 Code

## robot

### [Robot](src/main/java/frc/robot/Robot.java)

### [RobotMap](src/main/java/frc/robot/RobotMap.java)

### [Operator Interface](src/main/java/frc/robot/OI.java)

### [Subsystems](src/main/java/frc/robot/subsystems)

* [DriveTrain](src/main/java/frc/robot/subsystems/drivetrain/MecanumDriveSubsystem.java)
  * Mecanum drive subsystem
* [Elevator](src/main/java/frc/robot/subsystems/elevator/ElevatorSubsystem.java)
  * Elevator subsystem with PIDF controller implemented
* [Cargo Intake](src/main/java/frc/robot/subsystems/intakes/CargoSubsystem.java)
  * The dog cone intake subsystem
* [Hatch Intake](src/main/java/frc/robot/subsystems/intakes/HatchSubsystem.java)
  * The triangle intake subsystem
* [Cameras](src/main/java/frc/robot/subsystems/vision/CameraSubsystem.java)
  * The multicamera subsystem for driver vision

### [Commands](src/main/java/frc/robot/commands)

* [Drive Train Command](src/main/java/frc/robot/commands/MecanumDriveCommand.java)
* [Elevator Command](src/main/java/frc/robot/commands/ElevatorCommand.java)
* [Cargo Command](src/main/java/frc/robot/commands/CargoCommand.java)
* [Hatch Command](src/main/java/frc/robot/commands/HatchCommand.java)

### [Utils](src/main/java/frc/robot/utils)

* [XBOX Controller](src/main/java/frc/robot/utils/Controller.java)
  * Custom XBOX controller class for added functionality
* [PIDF Controller](src/main/java/frc/robot/utils/PIDFController.java)
  * Custom PIDF Controller

Visit our site at [nahsrobotics.org](https://nahsrobotics.org)

Written, cleaned, and documented by [Rafael Piloto](https://rafaelpiloto10.herokuapp.com/)
