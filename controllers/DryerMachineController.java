package controllers;

import devices.Device;
import devices.dryerMachine.DryerMachine;
import devices.dryerMachine.DryerMachineSettings;
import singleton.IoTController;

import java.util.Scanner;

public class DryerMachineController implements DeviceController {
    @Override
    public void controlDevice(IoTController controller, Device device, Scanner scanner) {
        if (!(device instanceof DryerMachine)) return;

        DryerMachine dryerMachine = (DryerMachine) device;

        while (true) {
            System.out.println("\nDryer Machine Control:");
            System.out.println("1. Configure Settings");
            System.out.println("2. Turn ON");
            System.out.println("3. Turn OFF");
            System.out.println("4. Back to Devices");

            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    configureSettings(dryerMachine, scanner);
                    break;
                case "2":
                    if (!dryerMachine.isOn()) {
                        dryerMachine.turnOn();
                    } else {
                        System.out.println("Error: Dryer Machine is already ON.");
                    }
                    break;
                case "3":
                    if (dryerMachine.isOn()) {
                        dryerMachine.turnOff();
                    } else {
                        System.out.println("Error: Dryer Machine is already OFF.");
                    }
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid Command!");
            }
        }
    }

    private void configureSettings(DryerMachine dryerMachine, Scanner scanner) {
        if (dryerMachine.isOn()) {
            System.out.println("Error: Cannot configure settings while the Dryer Machine is ON.");
            return;
        }

        DryerMachineSettings.Builder builder = new DryerMachineSettings.Builder();

        System.out.println("Select Mode:");
        System.out.println("1. Quick Drying");
        System.out.println("2. Ventilation Drying");
        System.out.println("3. Eco Drying");
        System.out.println("4. Synthetic Drying");

        String modeChoice = scanner.nextLine();
        switch (modeChoice) {
            case "1":
                builder.setMode("Quick Drying");
                break;
            case "2":
                builder.setMode("Ventilation Drying");
                break;
            case "3":
                builder.setMode("Eco Drying");
                break;
            case "4":
                builder.setMode("Synthetic Drying");
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

        System.out.println("Select Degree of Drying (1, 2, 3, 4):");
        int degreeOfDrying = Integer.parseInt(scanner.nextLine());
        if (degreeOfDrying >= 1 && degreeOfDrying <= 4) {
            builder.setDegreeOfDry(degreeOfDrying);
        } else {
            System.out.println("Invalid degree of drying selection.");
            return;
        }

        DryerMachineSettings settings = builder.build();
        dryerMachine.setSettings(settings);
        System.out.println("Dryer Machine settings configured successfully.");
    }
}
