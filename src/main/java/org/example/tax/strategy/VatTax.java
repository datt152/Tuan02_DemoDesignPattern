package org.example.tax.strategy;

public class VatTax implements TaxStrategy {
    private final double rate;

    public VatTax(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculate(double amount) {
        return amount * rate;
    }

    @Override
    public String getName() {
        return "VAT " + (rate * 100) + "%";
    }
}

