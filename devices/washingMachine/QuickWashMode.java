package devices.washingMachine;

import devices.DeviceMode;

public class QuickWashMode implements DeviceMode {
    @Override
    public void applyMode() {
        System.out.println("Quick Wash Mode: Short cycle for lightly soiled clothes.");
    }
}
