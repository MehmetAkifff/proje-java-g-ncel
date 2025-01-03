package singleton;

import devices.Device;
import observer.DeviceStatusObserver;

import java.util.ArrayList;
import java.util.List;

import commands.Command;

public class IoTController {
    private static IoTController instance;
    private final List<Device> devices = new ArrayList<>();
    private final List<DeviceStatusObserver> observers = new ArrayList<>();

    private IoTController() {}

    public static IoTController getInstance() {
        if (instance == null) {
            instance = new IoTController();
        }
        return instance;
    }

    public void registerDevice(Device device) {
        devices.add(device);
        notifyObservers(device.getName() + " has been registered.");
    }

    public void addObserver(DeviceStatusObserver observer) {
        observers.add(observer);
    }

    public void executeCommand(Command command) {
        command.execute();
    }
    public void undoCommand(Command command){
        command.undo();
    }

    // Yeni getDevices metodu
    public List<Device> getDevices() {
        return devices;
    }

    public void notifyObservers(String message) {
        for (DeviceStatusObserver observer : observers) {
            observer.update(message);
        }
    }
}
