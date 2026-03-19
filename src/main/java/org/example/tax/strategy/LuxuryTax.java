package org.example.tax.strategy;

public class LuxuryTax implements TaxStrategy {
    private final double rate;

    public LuxuryTax(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculate(double amount) {
        return amount * rate;
    }

    @Override
    public String getName() {
        return "Luxury " + (rate * 100) + "%";
    }
}

