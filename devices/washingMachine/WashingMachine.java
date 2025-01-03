package devices.washingMachine;

import observer.DeviceStatusObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import devices.Device;

public class WashingMachine implements Device {
    private boolean isOn = false;
    private WashingMachineSettings settings;
    private final List<DeviceStatusObserver> observers = new ArrayList<>();

    public void addObserver(DeviceStatusObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (DeviceStatusObserver observer : observers) {
            observer.update(message);
        }
    }

    @Override
    public String getName() {
        return "WashingMachine";
    }

    @Override
    public void turnOn() {
        if (isOn) {
            System.out.println("Error: WashingMachine is already ON.");
            return;
        }
        if (settings == null) {
            System.out.println("Error: Please configure washing machine settings before starting!");
            return;
        }
        isOn = true;
        System.out.println("WashingMachine is now ON with the following settings:");
        System.out.println(settings);

        // Mod süresi boyunca çalışmayı simüle et
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(() -> {
            isOn = false;
            System.out.println("WashingMachine has completed the " + settings.getMode() + " mode.");
            notifyObservers("WashingMachine completed: " + settings.getMode() + ".");
            scheduler.shutdown();
        }, settings.getDuration(), TimeUnit.SECONDS);
    }

    @Override
    public void turnOff() {
        if (!isOn) {
            System.out.println("Error: WashingMachine is already OFF.");
            return;
        }
        isOn = false;
        System.out.println("WashingMachine is now OFF.");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    public void setSettings(WashingMachineSettings settings) {
        if (isOn) {
            System.out.println("Error: Cannot change settings while the WashingMachine is ON.");
            return;
        }
        this.settings = settings;
        System.out.println("Settings applied: " + settings);
    }
}
