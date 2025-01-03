package observer;

public class NotificationService implements DeviceStatusObserver {
    @Override
    public void update(String message) {
        System.out.println("Notification Service: " + message);
    }
}
