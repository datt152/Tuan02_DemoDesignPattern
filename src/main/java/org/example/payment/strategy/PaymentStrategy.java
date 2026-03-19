package org.example.payment.strategy;

public interface PaymentStrategy {
    String getName();
    boolean pay(double amount);
}

