package controllers;

import devices.Device;
import devices.robotVacuum.RobotVacuum;
import singleton.IoTController;

import java.util.Scanner;

public class RobotVacuumController implements DeviceController {
    @Override
    public void controlDevice(IoTController controller, Device device, Scanner scanner) {
        if (!(device instanceof RobotVacuum)) return;

        RobotVacuum robotVacuum = (RobotVacuum) device;

        while (true) {
            System.out.println("\nRobot Vacuum Control:");
            System.out.println("1. Select Room");
            System.out.println("2. Turn ON");
            System.out.println("3. Turn OFF");
            System.out.println("4. Back to Devices");

            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    System.out.println("Available Rooms:");
                    System.out.println("1. Living Room");
                    System.out.println("2. Kitchen");
                    System.out.println("3. Bedroom");
                    System.out.println("Enter your choice:");
                    String roomChoice = scanner.nextLine();
                    String selectedRoom = switch (roomChoice) {
                        case "1" -> "Living Room";
                        case "2" -> "Kitchen";
                        case "3" -> "Bedroom";
                        default -> {
                            System.out.println("Invalid room selection.");
                            yield null;
                        }
                    };
                    if (selectedRoom != null) robotVacuum.selectRoom(selectedRoom);
                    break;
                case "2":
                    robotVacuum.turnOn();
                    break;
                case "3":
                    robotVacuum.turnOff();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid Command!");
            }
        }
    }
}
