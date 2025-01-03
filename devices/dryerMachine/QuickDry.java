package devices.dryerMachine;

import devices.DeviceMode;

public class QuickDry  implements DeviceMode{
    @Override
    public void applyMode() {
        System.out.println("Quick Dry Mode: Provides quick drying to save time.");
    }
    
}
