package devices.dishWasher;

public class DishWasherSettings {
    private final String mode;
    private final int temperature;
    private final int duration; // Mod süresi eklendi (saniye cinsinden)

    // Constructor
    private DishWasherSettings(Builder builder) {
        this.mode = builder.mode;
        this.temperature = builder.temperature;
        this.duration = builder.duration;
    }

    public String getMode() {
        return mode;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Mode: " + mode + ", Temperature: " + temperature + "°C, Duration: " + duration + " seconds";
    }

    // Builder sınıfı
    public static class Builder {
        private String mode;
        private int temperature;
        private int duration;

        // Set mode ve süreyi belirle
        public Builder setMode(String mode) {
            this.mode = mode;
            switch (mode) {
                case "Quick Wash":
                    this.duration = 2; // 2 dakika
                    break;
                case "Pre-Wash":
                    this.duration = 2; // 2 dakika
                    break;
                case "Intensive":
                    this.duration = 4; // 4 dakika
                    break;
                case "Half Load Mode":
                    this.duration = 2; // 2 dakika
                    break;
                case "Standard Wash":
                    this.duration = 3; // 3 dakika
                    break;
                case "Extra Rinse":
                    this.duration = 6; // 6 dakika
                    break;
            }
            return this;
        }

        // Set temperature
        public Builder setTemperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        // Build DishwasherSettings instance
        public DishWasherSettings build() {
            return new DishWasherSettings(this);
        }
    }
}
