package controllers;

import devices.Device;
import singleton.IoTController;

import java.util.Scanner;

public interface DeviceController {
    void controlDevice(IoTController controller, Device device, Scanner scanner);
}
