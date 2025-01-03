package devices.television;

import devices.Device;

public class Television implements Device {
        private boolean isOn = false;

        @Override
        public String getName() {
            return "Television";
        }

        @Override
        public void turnOn() {
            isOn = true;
            System.out.println("Television is now ON.");
        }

        @Override
        public void turnOff() {
            isOn = false;
            System.out.println("Television is now OFF.");
        }

        @Override
        public boolean isOn() {
            return isOn;
        }
    }
