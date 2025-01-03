import controllers.DeviceControlManager;
import devices.*;
import devices.airConditioning.AirConditioner;
import devices.airConditioning.AirConditionerSettings;
import devices.dishWasher.DishWasher;
import devices.dishWasher.DishWasherSettings;
import devices.dryerMachine.DryerMachine;
import devices.dryerMachine.DryerMachineSettings;
import devices.robotVacuum.RobotVacuum;
import devices.television.Television;
import devices.washingMachine.WashingMachine;
import devices.washingMachine.WashingMachineSettings;
import observer.*;
import singleton.IoTController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IoTController controller = IoTController.getInstance();
        DeviceControlManager controlManager = new DeviceControlManager();


        // Cihazları oluştur ve kaydet
        Device lightBulb = new LightBulb();
        Device garageDoor = new GarageDoor();
        Device television = new Television();
        Device robotVacuum = new RobotVacuum();
        Device washingMachine = new WashingMachine();
        Device dryerMachine = new DryerMachine();
        Device dishWasher = new DishWasher();
        Device airConditioner = new AirConditioner();
    
        controller.registerDevice(garageDoor);
        controller.registerDevice(lightBulb);
        controller.registerDevice(washingMachine);
        controller.registerDevice(dryerMachine);
        controller.registerDevice(dishWasher);
        controller.registerDevice(robotVacuum);
        controller.registerDevice(airConditioner);
        controller.registerDevice(television);

        // Gözlemci ekle
        UserInterface ui = new UserInterface();
        controller.addObserver(ui);

        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("\nIoT Controller:");
            System.out.println("1. List Devices");
            System.out.println("2. Exit");

             command = scanner.nextLine();

            switch (command) {
                case "1":
                    listDevices(controller, controlManager, scanner);
                    break;
                case "2":
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid Command!");
            }
        }
    }

    private static void listDevices(IoTController controller, DeviceControlManager controlManager, Scanner scanner) {
        while (true) {
            System.out.println("\nDevices:");
            int index = 1;
            for (Device device : controller.getDevices()) {
                System.out.println(index + ". " + device.getName());
                index++;
            }
            System.out.println(index + ". Back to Main Menu");

            String choice = scanner.nextLine();
            int selectedDeviceIndex;

            try {
                selectedDeviceIndex = Integer.parseInt(choice) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please select a valid option.");
                continue;
            }

            if (selectedDeviceIndex == controller.getDevices().size()) {
                // Ana menüye dön
                return;
            } else if (selectedDeviceIndex >= 0 && selectedDeviceIndex < controller.getDevices().size()) {
                Device selectedDevice = controller.getDevices().get(selectedDeviceIndex);
                controlManager.controlDevice(controller, selectedDevice, scanner);
            } else {
                System.out.println("Invalid selection! Please try again.");
            }}
        }


    
    private static void configureWashingMachineSettings(WashingMachine washingMachine, Scanner scanner) {
        if (washingMachine.isOn()) {
            System.out.println("Error: Cannot configure settings while WashingMachine is ON.");
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
    }

    private static void configureDryerMachineSettings(DryerMachine dryerMachine, Scanner scanner) {
        if (dryerMachine.isOn()) {
            System.out.println("Error: Cannot configure settings while DryerMachine is ON.");
            return;
        }
    
        DryerMachineSettings.Builder builder = new DryerMachineSettings.Builder();
    
        System.out.println("Select Mode:");
        System.out.println("1. Quick Drying");
        System.out.println("2. Ventilation Drying");
        System.out.println("3. Eco Drying");
        System.out.println("4. Syntetic Drying");
    
        String modeChoice = scanner.nextLine();
        switch (modeChoice) {
            case "1":
                builder.setMode("Quick Drying");
                break;
            case "2":
                builder.setMode("Ventilation Drying");
                break;
            case "3":
                builder.setMode(" Eco Drying");
                break;
            case "4":
                builder.setMode("Syntetic Drying");
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
    
        System.out.println("Select degree of drying (1, 2, 3, 4):");
        int degreeOfDry = Integer.parseInt(scanner.nextLine());
        if (degreeOfDry == 1 || degreeOfDry == 2 || degreeOfDry == 3 || degreeOfDry == 4) {
            builder.setDegreeOfDry(degreeOfDry);
        } else {
            System.out.println("Invalid degree of drying selection.");
            return;
        }
    
        DryerMachineSettings settings = builder.build();
        dryerMachine.setSettings(settings);
    }

    private static void configureDishWasherSettings(DishWasher dishWasher, Scanner scanner) {
        if (dishWasher.isOn()) {
            System.out.println("Error: Cannot configure settings while DishWasher is ON.");
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
    }

    public static void configureAirConditionerSettigs(AirConditioner airConditioner, Scanner scanner){
        if (airConditioner.isOn()) {
            System.out.println("Error: Cannot configure settings while AirConditioner is ON.");
            return;
        }

        AirConditionerSettings.Builder builder = new AirConditionerSettings.Builder();

        System.out.println("Select Mode:");
        System.out.println("1. Cooling");
        System.out.println("2. Heating");
        System.out.println("3. Dehumidifying");
        System.out.println("4. Fan");

        String modeChoice = scanner.nextLine();
        switch (modeChoice) {
            case "1":
                builder.setMode("Cooling");
                break;
            case "2":
                builder.setMode("Heating");
                break;
            case "3":
                builder.setMode("Dehumidifying");
                break;
            case "4":
                builder.setMode("Fan");
                break;
            default:
                System.out.println("Invalid mode selection.");
                return;
        }

        System.out.println("Select Temperature (16 to 30):");
        int temperature = Integer.parseInt(scanner.nextLine());
        if (temperature >= 16 && temperature <= 30) {
            builder.setTemperature(temperature);
        } else {
            System.out.println("Invalid temperature selection.");
            return;
        }

        System.out.println("Select Fan Speed (1: Low, 2: Medium, 3: High, 4: Auto):");
        int fanSpeed = Integer.parseInt(scanner.nextLine());

        String fanSpeedString;
        switch (fanSpeed) {
            case 1:
                fanSpeedString = "Low";
                break;
            case 2:
                fanSpeedString = "Medium";
                break;
            case 3:
                fanSpeedString = "High";
                break;
            case 4:
                fanSpeedString = "Auto";
                break;
            default:
            System.out.println("Invalid fan speed selection.");
            return;
        }
        builder.setFanSpeed(fanSpeedString);

        AirConditionerSettings settings = builder.build();
        airConditioner.setSettings(settings);

    }


    
}
