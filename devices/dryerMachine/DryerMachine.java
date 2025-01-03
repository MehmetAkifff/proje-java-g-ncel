package devices.dryerMachine;

import observer.DeviceStatusObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import devices.Device;

public class DryerMachine implements Device {
    private boolean isOn = false;
    private DryerMachineSettings settings;
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
        return "DryerMachine";
    }

    @Override
    public void turnOn() {
        if (isOn) {
            System.out.println("Error: DryerMachine is already ON.");
            return;
        }
        if (settings == null) {
            System.out.println("Error: Please configure dryer machine settings before starting!");
            return;
        }
        isOn = true;
        System.out.println("DryerMachine is now ON with the following settings:");
        System.out.println(settings);

        // Mod süresi boyunca çalışmayı simüle et
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(() -> {
            isOn = false;
            System.out.println("DryerMachine has completed the " + settings.getMode() + " mode.");
            notifyObservers("DryerMachine completed: " + settings.getMode() + ".");
            scheduler.shutdown();
        }, settings.getDuration(), TimeUnit.SECONDS);
    }

    @Override
    public void turnOff() {
        if (!isOn) {
            System.out.println("Error: DryerMachine is already OFF.");
            return;
        }
        isOn = false;
        System.out.println("DryerMachine is now OFF.");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    public void setSettings(DryerMachineSettings settings) {
        if (isOn) {
            System.out.println("Error: Cannot change settings while the DryerMachine is ON.");
            return;
        }
        this.settings = settings;
        System.out.println("Settings applied: " + settings);
    }
}