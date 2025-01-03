package devices.dishWasher;

import devices.DeviceMode;

public class HalfLoadMode implements DeviceMode {
    
    @Override
    public void applyMode() {
        System.out.println("Half Load Mode: Washes with less water and energy when the dishwasher is not fully loaded.");
    }

}
