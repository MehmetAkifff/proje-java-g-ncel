package devices.dryerMachine;

import devices.DeviceMode;

public class VentilationMode implements DeviceMode {
    @Override
    public void applyMode() {
        System.out.println("Ventilation Dry Mode: Provides high temperature drying for thick and durable fabrics.");
    }
    
}
