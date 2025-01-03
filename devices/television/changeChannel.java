package devices.television;


public class changeChannel {
    private final Television television;

    public changeChannel(Television television) {
        this.television = television;
    }

    public void setChannel(int channel) {
        if (!television.isOn()) {
            System.out.println("Error: Cannot change the channel while the television is OFF.");
            return;
        }
        if (channel > 0) {
            System.out.println("Changing to channel " + channel);
            // Kanal değiştirme işlemi
        } else {
            System.out.println("Invalid channel number. Please try again.");
        }
    }
}
