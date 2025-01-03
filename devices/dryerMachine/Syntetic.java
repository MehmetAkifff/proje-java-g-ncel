package devices.dryerMachine;

import devices.DeviceMode;

public class Syntetic implements DeviceMode {
    @Override
    public void applyMode() {
        System.out.println("Syntetic Dry Mode:Used at lower temperatures to protect delicate synthetic fabrics.");
    }
    
}
