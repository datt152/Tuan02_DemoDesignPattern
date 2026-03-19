package org.example.tax.decorator;

import org.example.tax.TaxContext;

public class EnvironmentalFeeDecorator extends TaxDecorator {
    private final double fee;

    public EnvironmentalFeeDecorator(TaxContext wrapped, double fee) {
        super(wrapped);
        this.fee = fee;
    }

    @Override
    public double calculateTax() {
        double base = wrapped.calculateTax();
        double total = base + fee;
        System.out.println("Cong phi moi truong: " + fee + " => Tong thue: " + total);
        return total;
    }
}

