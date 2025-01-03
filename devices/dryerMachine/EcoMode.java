package devices.dryerMachine;

import devices.DeviceMode;

public class EcoMode implements DeviceMode {
    @Override
    public void applyMode() {
        System.out.println("Eco Dry Mode: Drys with less energy consumption.");
    }
    
}
