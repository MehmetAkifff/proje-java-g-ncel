package devices.dishWasher;

import observer.DeviceStatusObserver;
import devices.Device;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DishWasher implements Device {
    private boolean isOn = false;
    private DishWasherSettings settings;
    private final List<DeviceStatusObserver> observers = new ArrayList<>();

    // Gözlemci ekleme
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
        return "DisWasher";
    }

    @Override
    public void turnOn() {
        if (isOn) {
            System.out.println("Error: Dishwasher is already ON.");
            return;
        }
        if (settings == null) {
            System.out.println("Error: Please configure dishwasher settings before starting!");
            return;
        }
        isOn = true;
        System.out.println("Dishwasher is now ON with the following settings:");
        System.out.println(settings);

        // Program süresi boyunca çalışmayı simüle et
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(() -> {
            isOn = false;
            System.out.println("Dishwasher has completed the " + settings.getMode() + " program.");
            notifyObservers("Dishwasher completed: " + settings.getMode() + ".");
            scheduler.shutdown();
        }, settings.getDuration(), TimeUnit.SECONDS);
    }

    @Override
    public void turnOff() {
        if (!isOn) {
            System.out.println("Error: Dishwasher is already OFF.");
            return;
        }
        isOn = false;
        System.out.println("Dishwasher is now OFF.");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    public void setSettings(DishWasherSettings settings) {
        if (isOn) {
            System.out.println("Error: Cannot change settings while the Dishwasher is ON.");
            return;
        }
        this.settings = settings;
        System.out.println("Settings applied: " + settings);
    }
}

