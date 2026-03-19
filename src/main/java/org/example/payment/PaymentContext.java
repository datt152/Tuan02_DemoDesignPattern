package org.example.payment;

import org.example.payment.state.PendingState;
import org.example.payment.state.PaymentState;
import org.example.payment.strategy.PaymentStrategy;

public class PaymentContext {
    private PaymentState state;
    private PaymentStrategy strategy;
    private double amount;

    public PaymentContext(double amount, PaymentStrategy strategy) {
        this.amount = amount;
        this.strategy = strategy;
        this.state = new PendingState();
    }

    public void setState(PaymentState state) {
        this.state = state;
        System.out.println("Trang thai thanh toan -> " + state.getStatus());
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean attemptPay() {
        if (strategy == null) {
            System.out.println("Khong co phuong thuc thanh toan");
            return false;
        }
        return strategy.pay(amount);
    }

    public void process() {
        state.handle(this);
    }

    public void displayInfo() {
        System.out.println("So tien thanh toan: " + amount);
        System.out.println("Phuong thuc: " + (strategy != null ? strategy.getName() : "(none)"));
        System.out.println("Trang thai: " + state.getStatus());
    }
}

