package org.example.payment.strategy;

public class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String getName() {
        return "Credit Card";
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Thanh toan bang the: " + cardNumber + " so tien " + amount);
        return true;
    }
}

