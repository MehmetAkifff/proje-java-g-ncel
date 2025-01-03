package controllers;

import devices.Device;
import devices.television.Television;
import devices.television.changeChannel;
import devices.television.changeVolume;
import singleton.IoTController;

import java.util.Scanner;

public class TelevisionController implements DeviceController {
    @Override
    public void controlDevice(IoTController controller, Device device, Scanner scanner) {
        if (!(device instanceof Television)) return;

        Television television = (Television) device;
        changeChannel changeChannel = new changeChannel(television);
        changeVolume changeVolume = new changeVolume(television);

        while (true) {
            if (!television.isOn()) {
                System.out.println("\nTelevision Control:");
                System.out.println("1. Turn ON");
                System.out.println("2. Back to Devices");

                String command = scanner.nextLine();
                switch (command) {
                    case "1":
                        television.turnOn();
                        break;
                    case "2":
                        return;
                    default:
                        System.out.println("Invalid Command!");
                }
            } else {
                System.out.println("\nTelevision Control:");
                System.out.println("1. Change Channel");
                System.out.println("2. Increase Volume");
                System.out.println("3. Decrease Volume");
                System.out.println("4. Turn OFF");
                System.out.println("5. Back to Devices");

                String command = scanner.nextLine();
                switch (command) {
                    case "1":
                        System.out.println("Enter the channel number:");
                        int channel = Integer.parseInt(scanner.nextLine());
                        changeChannel.setChannel(channel);
                        break;
                    case "2":
                        System.out.println("Enter the volume increase amount:");
                        int increaseAmount = Integer.parseInt(scanner.nextLine());
                        changeVolume.increaseVolume(increaseAmount);
                        break;
                    case "3":
                        System.out.println("Enter the volume decrease amount:");
                        int decreaseAmount = Integer.parseInt(scanner.nextLine());
                        changeVolume.decreaseVolume(decreaseAmount);
                        break;
                    case "4":
                        television.turnOff();
                        break;
                    case "5":
                        return;
                    default:
                        System.out.println("Invalid Command!");
                }
            }
        }
    }
}
