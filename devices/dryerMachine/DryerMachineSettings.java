package devices.dryerMachine;

public class DryerMachineSettings {
    private String mode;
    private int temperature;
    private int degreeOfDry;
    private int duration;

    private DryerMachineSettings(Builder builder) {
        this.mode = builder.mode;
        this.temperature = builder.temperature;
        this.degreeOfDry = builder.degreeOfDry;
        this.duration = builder.duration;
    }

    public String getMode() {
        return mode;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getDegreeOfDry(){
        return degreeOfDry;
    }


    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Mode: " + mode + ", Temperature: " + temperature + "°C, degree of dryness: " + degreeOfDry + " level, Duration: "
                + duration + " seconds";
    }

    public static class Builder {
        private String mode;
        private int temperature;
        private int degreeOfDry;
        private int duration;

        public Builder setMode(String mode) {
            this.mode = mode;
            switch (mode) {
                case "Quick Dry":
                    this.duration = 1; // 20 seconds
                    break;
                case "Ventilation Dry":
                    this.duration = 2; // 40 seconds
                    break;
                case "Eco Dry":
                    this.duration = 3; // 60 seconds
                    break;
                case "Syntetic Dry":
                    this.duration = 4; // 50 seconds
                    break;
            }
            return this;
        }

        public Builder setTemperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder setDegreeOfDry(int degreeOfDry) {
            this.degreeOfDry = degreeOfDry;
            return this;
        }

        public DryerMachineSettings build() {
            return new DryerMachineSettings(this);
        }
    }
}