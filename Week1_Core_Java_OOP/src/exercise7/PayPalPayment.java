package exercise7;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " securely using PayPal.");
    }
}