package exercise5;

public class SMSDecorator extends NotifierDecorator {
    public SMSDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Send the email first
        System.out.println("Sending SMS alert: " + message); // Add SMS decoration
    }
}