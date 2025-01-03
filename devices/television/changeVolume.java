package devices.television;

public class changeVolume {
    private final Television television;

    public changeVolume(Television television) {
        this.television = television;
    }

    public void increaseVolume(int amount) {
        if (!television.isOn()) {
            System.out.println("Error: Cannot increase volume while the television is OFF.");
            return;
        }
        System.out.println("Increasing volume by " + amount);
        // Ses artırma işlemi
    }

    public void decreaseVolume(int amount) {
        if (!television.isOn()) {
            System.out.println("Error: Cannot decrease volume while the television is OFF.");
            return;
        }
        System.out.println("Decreasing volume by " + amount);
        // Ses azaltma işlemi
    }
}