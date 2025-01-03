package devices.airConditioning;

import devices.DeviceMode;

public class Heating implements DeviceMode {
    
    @Override
    public void applyMode() {
        System.out.println("Heating Mode: Provides warmth to keep the room cozy.");
    }
    
}
