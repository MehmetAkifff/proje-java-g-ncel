package devices;

public class GarageDoor implements Device {
    private boolean isOn = false;

    @Override
    public String getName() {
        return "GarageDoor";
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Garage door is now ON.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Garage door is now OFF.");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }
    
}
