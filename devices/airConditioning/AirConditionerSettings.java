package devices.airConditioning;

public class AirConditionerSettings {
    private final String mode; // Mod (cooling, heating, etc.)
    private final String fanSpeed; // Fan Hızı (low, medium, high, auto)
    private final int temperature; // Sıcaklık
    private final int duration; // Süre (dakika cinsinden)

    // Constructor
    private AirConditionerSettings(Builder builder) {
        this.mode = builder.mode;
        this.fanSpeed = builder.fanSpeed;
        this.temperature = builder.temperature;
        this.duration = builder.duration;
    }

    public String getMode() {
        return mode;
    }

    public String getFanSpeed() {
        return fanSpeed;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Mode: " + mode + ", Fan Speed: " + fanSpeed + ", Temperature: " + temperature 
               + "°C, Duration: " + duration + " minutes";
    }

    // Builder Sınıfı
    public static class Builder {
        private String mode;
        private String fanSpeed;
        private int temperature;
        private int duration;

        // Mod seçimi
        public Builder setMode(String mode) {
            this.mode = mode;
            switch (mode) {
                case "Cooling":
                    this.duration = 3; // Örnek: Soğutma modu 30 dakika
                    break;
                case "Heating":
                    this.duration = 4; // Örnek: Isıtma modu 40 dakika
                    break;
                case "Fan":
                    this.duration = 2; // Örnek: Fan modu 20 dakika
                    break;
                case "Dehumidify":
                    this.duration = 2; // Örnek: Nem alma modu 25 dakika
                    break;
                case "Auto":
                    this.duration = 6; // Örnek: Otomatik mod 60 dakika
                    break;
                default:
                    throw new IllegalArgumentException("Invalid mode: " + mode);
            }
            return this;
        }

        // Fan hızını ayarla
        public Builder setFanSpeed(String fanSpeed) {
            if (!fanSpeed.equals("Low") && !fanSpeed.equals("Medium") 
                && !fanSpeed.equals("High") && !fanSpeed.equals("Auto")) {
                throw new IllegalArgumentException("Invalid fan speed: " + fanSpeed);
            }
            this.fanSpeed = fanSpeed;
            return this;
        }

        // Sıcaklık ayarı
        public Builder setTemperature(int temperature) {
            if (temperature < 16 || temperature > 30) {
                throw new IllegalArgumentException("Temperature must be between 16°C and 30°C.");
            }
            this.temperature = temperature;
            return this;
        }

        // Ayarları oluştur
        public AirConditionerSettings build() {
            return new AirConditionerSettings(this);
        }
    }
}
