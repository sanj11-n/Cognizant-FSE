package exercise6;

public class UserObserver implements Observer {
    private final String userName;

    public UserObserver(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String eventData) {
        System.out.println("Notification to " + userName + ": " + eventData);
    }
}