package devices.dishWasher;

import devices.DeviceMode;

public class QuickMode implements DeviceMode {

    @Override
    public void applyMode() {
        System.out.println("Quick Mode: A quick wash program for lightly soiled dishes.");
    }

    
}
