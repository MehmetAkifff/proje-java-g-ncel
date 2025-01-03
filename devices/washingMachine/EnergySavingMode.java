package devices.washingMachine;

import devices.DeviceMode;


public class EnergySavingMode implements DeviceMode {
    @Override
    public void applyMode() {
        System.out.println("Energy Saving Mode: Optimized for minimal energy usage.");
    }
}
