package devices.washingMachine;

import devices.DeviceMode;

public class IntensiveWashMode implements DeviceMode {
    @Override
    public void applyMode() {
        System.out.println("Intensive Wash Mode: Longer cycle for heavily soiled clothes.");
    }
}
