package com.cognizant.week3;

interface PaymentService {
    void processPayment(String account, double amount);
}

class SimplePaymentService implements PaymentService {
    @Override
    public void processPayment(String account, double amount) {
        System.out.println("[CORE BUSINESS LOGIC] Executing payment transfer of $" + amount + " to account: " + account);
    }
}

class PaymentServiceAOPProxy implements PaymentService {
    private final PaymentService targetService;

    public PaymentServiceAOPProxy(PaymentService targetService) {
        this.targetService = targetService;
    }

    @Override
    public void processPayment(String account, double amount) {
        System.out.println("[AOP ASPECT - @Before] LOG: Initiating transaction security check for account " + account + "...");
        targetService.processPayment(account, amount);
        System.out.println("[AOP ASPECT - @After] LOG: Transaction successfully completed and ledger updated.");
    }
}

public class AOPLoggingSystem {
    public static void main(String[] args) {
        System.out.println("=== Week 3: Exercise 3 - Aspect-Oriented Programming (AOP) ===");
        PaymentService realService = new SimplePaymentService();
        PaymentService proxyService = new PaymentServiceAOPProxy(realService);
        proxyService.processPayment("Sanjana-9921", 750.00);
    }
}