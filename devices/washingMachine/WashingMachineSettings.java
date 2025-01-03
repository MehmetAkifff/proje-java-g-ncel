package devices.washingMachine;

public class WashingMachineSettings {
    private final String mode;
    private final int temperature;
    private final int spinSpeed;
    private final int duration; // Mod süresi eklendi (saniye cinsinden)

    private WashingMachineSettings(Builder builder) {
        this.mode = builder.mode;
        this.temperature = builder.temperature;
        this.spinSpeed = builder.spinSpeed;
        this.duration = builder.duration;
    }

    public String getMode() {
        return mode;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getSpinSpeed() {
        return spinSpeed;
    }

    public int getDuration() {
        return duration; // Süreyi döndürür
    }

    @Override
    public String toString() {
        return "Mode: " + mode + ", Temperature: " + temperature + "°C, Spin Speed: " + spinSpeed + " RPM, Duration: " + duration + " seconds";
    }

    public static class Builder {
        private String mode;
        private int temperature;
        private int spinSpeed;
        private int duration;

        public Builder setMode(String mode) {
            this.mode = mode;
            switch (mode) {
                case "Quick Wash":
                    this.duration = 2; // 20 saniye
                    break;
                case "Daily Wash":
                    this.duration = 4; // 40 saniye
                    break;
                case "Intensive Wash":
                    this.duration = 6; // 60 saniye
                    break;
                case "Energy Saving":
                    this.duration = 5; // 50 saniye
                    break;
            }
            return this;
        }

        public Builder setTemperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder setSpinSpeed(int spinSpeed) {
            this.spinSpeed = spinSpeed;
            return this;
        }

        public WashingMachineSettings build() {
            return new WashingMachineSettings(this);
        }
    }
}
