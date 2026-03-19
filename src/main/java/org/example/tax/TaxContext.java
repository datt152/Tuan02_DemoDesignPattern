package org.example.tax;

import org.example.tax.state.DraftState;
import org.example.tax.state.TaxState;
import org.example.tax.strategy.TaxStrategy;

public class TaxContext {
    private TaxState state;
    private TaxStrategy strategy;
    private double amount;

    public TaxContext(double amount, TaxStrategy strategy) {
        this.amount = amount;
        this.strategy = strategy;
        this.state = new DraftState();
    }

    public void setState(TaxState state) {
        this.state = state;
        System.out.println("Trang thai thue -> " + state.getStatus());
    }

    public void setStrategy(TaxStrategy strategy) {
        this.strategy = strategy;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double calculateTax() {
        double tax = strategy.calculate(amount);
        System.out.println("Ap dung " + strategy.getName() + " cho " + amount + " => Thue: " + tax);
        return tax;
    }

    public void nextStep() {
        state.handle(this);
    }

    public void displayInfo() {
        System.out.println("So tien tinh thue: " + amount);
        System.out.println("Chien luoc hien tai: " + (strategy != null ? strategy.getName() : "(none)"));
        System.out.println("Trang thai: " + state.getStatus());
    }
}

