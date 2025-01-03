package controllers;

import devices.Device;
import devices.washingMachine.WashingMachine;
import devices.washingMachine.WashingMachineSettings;
import singleton.IoTController;

import java.util.Scanner;

public class WashingMachineController implements DeviceController {
    @Override
    public void controlDevice(IoTController controller, Device device, Scanner scanner) {
        if (!(device instanceof WashingMachine)) return;

        WashingMachine washingMachine = (WashingMachine) device;

        while (true) {
            System.out.println("\nWashing Machine Control:");
            System.out.println("1. Configure Settings");
            System.out.println("2. Turn ON");
            System.out.println("3. Turn OFF");
            System.out.println("4. Back to Devices");

            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    configureSettings(washingMachine, scanner);
                    break;
                case "2":
                    if (!washingMachine.isOn()) {
                        washingMachine.turnOn();
                    } else {
                        System.out.println("Error: Washing Machine is already ON.");
                    }
                    break;
                case "3":
                    if (washingMachine.isOn()) {
                        washingMachine.turnOff();
                    } else {
                        System.out.println("Error: Washing Machine is already OFF.");
                    }
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid Command!");
            }
        }
    }

    private void configureSettings(WashingMachine washingMachine, Scanner scanner) {
        if (washingMachine.isOn()) {
            System.out.println("Error: Cannot configure settings while the Washing Machine is ON.");
            return;
        }

        WashingMachineSettings.Builder builder = new WashingMachineSettings.Builder();

        System.out.println("Select Mode:");
        System.out.println("1. Quick Wash");
        System.out.println("2. Daily Wash");
        System.out.println("3. Intensive Wash");
        System.out.println("4. Energy Saving");

        String modeChoice = scanner.nextLine();
        switch (modeChoice) {
            case "1":
                builder.setMode("Quick Wash");
                break;
            case "2":
                builder.setMode("Daily Wash");
                break;
            case "3":
                builder.setMode("Intensive Wash");
                break;
            case "4":
                builder.setMode("Energy Saving");
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

        System.out.println("Select Spin Speed (800, 1000, 1200, 1400):");
        int spinSpeed = Integer.parseInt(scanner.nextLine());
        if (spinSpeed == 800 || spinSpeed == 1000 || spinSpeed == 1200 || spinSpeed == 1400) {
            builder.setSpinSpeed(spinSpeed);
        } else {
            System.out.println("Invalid spin speed selection.");
            return;
        }

        WashingMachineSettings settings = builder.build();
        washingMachine.setSettings(settings);
        System.out.println("Washing Machine settings configured successfully.");
    }
}
