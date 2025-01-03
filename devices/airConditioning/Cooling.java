package devices.airConditioning;

import devices.DeviceMode;

public class Cooling implements DeviceMode {

    @Override
    public void applyMode() {
        System.out.println("Cooling Mode: Provides a cooling effect for a comfortable environment.");
    }
    
}
