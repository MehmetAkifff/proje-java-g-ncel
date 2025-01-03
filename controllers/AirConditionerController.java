package controllers;

import devices.Device;
import devices.airConditioning.AirConditioner;
import devices.airConditioning.AirConditionerSettings;
import singleton.IoTController;

import java.util.Scanner;

public class AirConditionerController implements DeviceController {
    @Override
    public void controlDevice(IoTController controller, Device device, Scanner scanner) {
        if (!(device instanceof AirConditioner)) return;

        AirConditioner airConditioner = (AirConditioner) device;

        while (true) {
            System.out.println("\nAir Conditioner Control:");
            System.out.println("1. Configure Settings");
            System.out.println("2. Turn ON");
            System.out.println("3. Turn OFF");
            System.out.println("4. Back to Devices");

            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    configureSettings(airConditioner, scanner);
                    break;
                case "2":
                    airConditioner.turnOn();
                    break;
                case "3":
                    airConditioner.turnOff();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid Command!");
            }
        }
    }

    private void configureSettings(AirConditioner airConditioner, Scanner scanner) {
        if (airConditioner.isOn()) {
            System.out.println("Error: Cannot configure settings while the Air Conditioner is ON.");
            return;
        }

        AirConditionerSettings.Builder builder = new AirConditionerSettings.Builder();

        // Mod seçimi
        System.out.println("Select Mode:");
        System.out.println("1. Cooling");
        System.out.println("2. Heating");
        System.out.println("3. Fan");
        System.out.println("4. Dehumidify");
        System.out.println("5. Auto");

        String modeChoice = scanner.nextLine();
        switch (modeChoice) {
            case "1":
                builder.setMode("Cooling");
                break;
            case "2":
                builder.setMode("Heating");
                break;
            case "3":
                builder.setMode("Fan");
                break;
            case "4":
                builder.setMode("Dehumidify");
                break;
            case "5":
                builder.setMode("Auto");
                break;
            default:
                System.out.println("Invalid mode selection.");
                return;
        }

        // Fan hızı seçimi
        System.out.println("Select Fan Speed:");
        System.out.println("1. Low");
        System.out.println("2. Medium");
        System.out.println("3. High");
        System.out.println("4. Auto");

        String fanSpeedChoice = scanner.nextLine();
        switch (fanSpeedChoice) {
            case "1":
                builder.setFanSpeed("Low");
                break;
            case "2":
                builder.setFanSpeed("Medium");
                break;
            case "3":
                builder.setFanSpeed("High");
                break;
            case "4":
                builder.setFanSpeed("Auto");
                break;
            default:
                System.out.println("Invalid fan speed selection.");
                return;
        }

        // Sıcaklık ayarı
        System.out.println("Enter Temperature (16°C - 30°C):");
        int temperature;
        try {
            temperature = Integer.parseInt(scanner.nextLine());
            builder.setTemperature(temperature);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println("Invalid temperature input.");
            return;
        }

        // Ayarları uygulama
        AirConditionerSettings settings = builder.build();
        airConditioner.setSettings(settings);
        System.out.println("Settings applied: " + settings);
    }
}
