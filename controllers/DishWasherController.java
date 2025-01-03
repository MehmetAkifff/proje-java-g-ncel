package controllers;

import devices.Device;
import devices.dishWasher.DishWasher;
import devices.dishWasher.DishWasherSettings;
import singleton.IoTController;

import java.util.Scanner;

public class DishWasherController implements DeviceController {
    @Override
    public void controlDevice(IoTController controller, Device device, Scanner scanner) {
        if (!(device instanceof DishWasher)) return;

        DishWasher dishWasher = (DishWasher) device;

        while (true) {
            System.out.println("\nDish Washer Control:");
            System.out.println("1. Configure Settings");
            System.out.println("2. Turn ON");
            System.out.println("3. Turn OFF");
            System.out.println("4. Back to Devices");

            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    configureSettings(dishWasher, scanner);
                    break;
                case "2":
                    if (!dishWasher.isOn()) {
                        dishWasher.turnOn();
                    } else {
                        System.out.println("Error: Dish Washer is already ON.");
                    }
                    break;
                case "3":
                    if (dishWasher.isOn()) {
                        dishWasher.turnOff();
                    } else {
                        System.out.println("Error: Dish Washer is already OFF.");
                    }
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid Command!");
            }
        }
    }

    private void configureSettings(DishWasher dishWasher, Scanner scanner) {
        if (dishWasher.isOn()) {
            System.out.println("Error: Cannot configure settings while the Dish Washer is ON.");
            return;
        }

        DishWasherSettings.Builder builder = new DishWasherSettings.Builder();

        System.out.println("Select Mode:");
        System.out.println("1. Quick Wash");
        System.out.println("2. Pre-Wash");
        System.out.println("3. Intensive Wash");
        System.out.println("4. Half Load Mode");
        System.out.println("5. Standard Wash");
        System.out.println("6. Extra Rinse");

        String modeChoice = scanner.nextLine();
        switch (modeChoice) {
            case "1":
                builder.setMode("Quick Wash");
                break;
            case "2":
                builder.setMode("Pre-Wash");
                break;
            case "3":
                builder.setMode("Intensive Wash");
                break;
            case "4":
                builder.setMode("Half Load Mode");
                break;
            case "5":
                builder.setMode("Standard Wash");
                break;
            case "6":
                builder.setMode("Extra Rinse");
                break;
            default:
                System.out.println("Invalid mode selection.");
                return;
        }

        System.out.println("Select Temperature (30, 40, 60, 90):");
        int temperature = Integer.parseInt(scanner.nextLine());
        if (temperature == 30 || temperature == 40 || temperature == 60 || temperature == 90) {
            builder.setTemperature(temperature);
        } else {
            System.out.println("Invalid temperature selection.");
            return;
        }

        DishWasherSettings settings = builder.build();
        dishWasher.setSettings(settings);
        System.out.println("Dish Washer settings configured successfully.");
    }
}
