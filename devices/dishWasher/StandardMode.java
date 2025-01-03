package devices.dishWasher;

import devices.DeviceMode;

public class StandardMode implements DeviceMode {

    @Override
    public void applyMode() {
        System.out.println("Standard Mode: Ideal for everyday lightly soiled dishes.");
    }

    
}
