package controllers;

import devices.Device;
import devices.airConditioning.AirConditioner;
import devices.dishWasher.DishWasher;
import devices.dryerMachine.DryerMachine;
import devices.robotVacuum.RobotVacuum;
import devices.television.Television;
import devices.washingMachine.WashingMachine;
import singleton.IoTController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DeviceControlManager {
    private final Map<Class<? extends Device>, DeviceController> controllerMap = new HashMap<>();

    public DeviceControlManager() {
        // Her cihaz türü için ilgili kontrol sınıfını kaydet
        controllerMap.put(Television.class, new TelevisionController());
        controllerMap.put(RobotVacuum.class, new RobotVacuumController());
        controllerMap.put(WashingMachine.class, new WashingMachineController());
        controllerMap.put(DryerMachine.class, new DryerMachineController());
        controllerMap.put(DishWasher.class, new DishWasherController());
        controllerMap.put(AirConditioner.class, new AirConditionerController());


        // Diğer cihazlar için kontrol sınıflarını ekleyebilirsiniz.
    }

    public void controlDevice(IoTController controller, Device device, Scanner scanner) {
        DeviceController deviceController = controllerMap.get(device.getClass());
        if (deviceController != null) {
            deviceController.controlDevice(controller, device, scanner);
        } else {
            System.out.println("No controller available for this device.");
        }
    }
}
