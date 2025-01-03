package observer;

public class UserInterface implements DeviceStatusObserver {
    @Override
    public void update(String message) {
        System.out.println("User Notification: " + message);
    }
}
