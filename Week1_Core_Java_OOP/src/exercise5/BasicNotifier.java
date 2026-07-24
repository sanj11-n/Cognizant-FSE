package exercise5;

public class BasicNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending standard Email: " + message);
    }
}