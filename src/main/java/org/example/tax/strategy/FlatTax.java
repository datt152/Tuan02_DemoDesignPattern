package org.example.tax.strategy;

public class FlatTax implements TaxStrategy {
    private final double fixedAmount;

    public FlatTax(double fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    @Override
    public double calculate(double amount) {
        return fixedAmount;
    }

    @Override
    public String getName() {
        return "Flat " + fixedAmount;
    }
}

