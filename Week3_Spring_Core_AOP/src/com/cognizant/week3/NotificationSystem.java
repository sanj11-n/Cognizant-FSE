package com.cognizant.week3;

// 1. Define the service capability interface
interface MessageService {
    void sendMessage(String recipient, String message);
}

// 2. Implementation: SMS Notification Service
class SMSService implements MessageService {
    @Override
    public void sendMessage(String recipient, String message) {
        System.out.println("[SMS SENT] To " + recipient + ": " + message);
    }
}

// 3. Implementation: Email Notification Service
class EmailService implements MessageService {
    @Override
    public void sendMessage(String recipient, String message) {
        System.out.println("[EMAIL SENT] To " + recipient + ": " + message);
    }
}

// 4. Client Class that uses Dependency Injection (DI)
class NotificationManager {
    private final MessageService service;

    // The dependency is injected cleanly via this constructor
    public NotificationManager(MessageService service) {
        this.service = service;
    }

    public void sendAlert(String user, String alertText) {
        service.sendMessage(user, alertText);
    }
}

// 5. Main Execution Class
public class NotificationSystem {
    public static void main(String[] args) {
        System.out.println("=== Week 3: Exercise 1 - Dependency Injection ===");

        // Inject SMS Service dependency
        NotificationManager smsManager = new NotificationManager(new SMSService());
        smsManager.sendAlert("Sanjana", "Your database transaction was successful!");

        System.out.println("-------------------------------------------------");

        // Inject Email Service dependency flawlessly without altering client logic
        NotificationManager emailManager = new NotificationManager(new EmailService());
        emailManager.sendAlert("Sanjana", "Weekly FSE Training progress report generated.");
    }
}