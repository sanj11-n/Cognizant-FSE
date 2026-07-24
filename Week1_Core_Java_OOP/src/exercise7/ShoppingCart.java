package exercise7;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // Dynamically set the payment formula at runtime
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            System.out.println("Error: Please select a payment strategy first.");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}