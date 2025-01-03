package devices.robotVacuum;

import java.util.HashSet;
import java.util.Set;

import devices.Device;

public class RobotVacuum implements Device {
    private boolean isOn;
    private String name;
    private Set<String> cleanedRooms;

    public RobotVacuum() {
        this.name = "Robot Vacuum";
        this.isOn = false;
        this.cleanedRooms = new HashSet<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void turnOn() {
        if (isOn) {
            System.out.println("Error: Device is already ON.");
        } else {
            this.isOn = true;
            System.out.println(this.name + " has been turned ON.");
        }
    }

    @Override
    public void turnOff() {
        if (!isOn) {
            System.out.println("Error: Device is already OFF.");
        } else {
            this.isOn = false;
            System.out.println(this.name + " has been turned OFF.");
        }
    }

    public void selectRoom(String room) {
        if (!isOn) {
            System.out.println("Error: Cannot clean rooms while " + this.name + " is OFF.");
            return;
        }
        if (room == null || room.isEmpty()) {
            System.out.println("Error: Invalid room selection.");
            return;
        }
        if (cleanedRooms.contains(room)) {
            System.out.println("Room '" + room + "' has already been cleaned.");
        } else {
            cleanedRooms.add(room);
            System.out.println("Cleaning room: " + room);
        }
    }
}
