package devices.airConditioning;

import devices.DeviceMode;

public class Fan implements DeviceMode {

    @Override
    public void applyMode() {
        System.out.println("Fan Mode: Circulates air without changing the temperature.");
    }
}
    
