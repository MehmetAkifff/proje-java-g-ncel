package devices.washingMachine;

import devices.DeviceMode;

public class Cotton implements DeviceMode{
    @Override
    public void applyMode() {
        System.out.println("Cotton Wash Mode:Provides high temperature drying for thick and durable fabrics.");
    }    
}
