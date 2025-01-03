package devices;

public class LightBulb implements Device {
    private boolean isOn = false;

    @Override
    public String getName() {
        return "LightBulb";
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("LightBulb is now ON.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("LightBulb is now OFF.");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }
}
