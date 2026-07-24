package exercise1;

import exercise2.Document;
import exercise2.DocumentFactory;
import exercise3.Computer;
import exercise4.Adaptee;
import exercise4.Adapter;
import exercise4.LegacyTarget;
import exercise5.BasicNotifier;
import exercise5.Notifier;
import exercise5.SMSDecorator;
import exercise6.NewsAgency;
import exercise6.UserObserver;
import exercise7.ShoppingCart;
import exercise7.CreditCardPayment;
import exercise7.PayPalPayment;
import exercise8.Light;
import exercise8.LightOnCommand;
import exercise8.RemoteControl;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- TESTING EXERCISE 1: SINGLETON PATTERN ---");
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("Application started smoothly.");
        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both variables use the exact same instance!\n");
        }

        System.out.println("--- TESTING EXERCISE 2: FACTORY METHOD PATTERN ---");
        Document doc1 = DocumentFactory.createDocument("PDF");
        if (doc1 != null) doc1.open();
        Document doc2 = DocumentFactory.createDocument("WORD");
        if (doc2 != null) doc2.open();
        System.out.println();

        System.out.println("--- TESTING EXERCISE 3: BUILDER PATTERN ---");
        Computer myComputer = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .build();
        myComputer.showConfiguration();
        System.out.println();

        System.out.println("--- TESTING EXAPTER PATTERN ---");
        Adaptee modernSystem = new Adaptee();
        LegacyTarget adapter = new Adapter(modernSystem);
        adapter.requestOldSystem();
        System.out.println();

        System.out.println("--- TESTING EXERCISE 5: DECORATOR PATTERN ---");
        Notifier emailNotifier = new BasicNotifier();
        Notifier wrappedSMSNotifier = new SMSDecorator(emailNotifier);
        wrappedSMSNotifier.send("System maintenance alert!");
        System.out.println();

        System.out.println("--- TESTING EXERCISE 6: OBSERVER PATTERN ---");
        NewsAgency agency = new NewsAgency();
        UserObserver user1 = new UserObserver("Alex");
        UserObserver user2 = new UserObserver("Sam");
        agency.registerObserver(user1);
        agency.registerObserver(user2);
        agency.setNews("Java Design Patterns hands-on is moving perfectly!");
        System.out.println();

        System.out.println("--- TESTING EXERCISE 7: STRATEGY PATTERN ---");
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(150);
        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(300);
        System.out.println();

        System.out.println("--- TESTING EXERCISE 8: COMMAND PATTERN ---");
        Light livingRoomLight = new Light();
        LightOnCommand switchOn = new LightOnCommand(livingRoomLight);
        RemoteControl remote = new RemoteControl();

        remote.setCommand(switchOn);
        remote.pressButton();
    }
}