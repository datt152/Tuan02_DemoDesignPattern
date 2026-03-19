package org.example.payment.strategy;

public class PaypalPayment implements PaymentStrategy {
    private final String account;

    public PaypalPayment(String account) {
        this.account = account;
    }

    @Override
    public String getName() {
        return "PayPal";
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Thanh toan qua PayPal: " + account + " so tien " + amount);
        return true;
    }
}

