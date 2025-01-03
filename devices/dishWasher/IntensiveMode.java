package devices.dishWasher;

import devices.DeviceMode;

public class IntensiveMode implements DeviceMode {

    @Override
    public void applyMode() {
        System.out.println("Intensive Mode: Suitable for heavily soiled dishes like pots and pans.");
    }

    
}