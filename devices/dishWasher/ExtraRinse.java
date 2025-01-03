package devices.dishWasher;

import devices.DeviceMode;

public class ExtraRinse implements DeviceMode {

    @Override
    public void applyMode() {
        System.out.println("Extra Rinse Mode: Provides a better rinse for the dishes.");
    }
    
}
