package devices.dishWasher;

import devices.DeviceMode;

public class PreWash implements DeviceMode {
    @Override
    public void applyMode() {
        System.out.println("Pre-Wash Mode: pre-washes the dishes.");
    }

    
}
