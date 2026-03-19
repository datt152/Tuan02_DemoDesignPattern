package org.example.tax.decorator;

import org.example.tax.TaxContext;

public class LuxurySurchargeDecorator extends TaxDecorator {
    private final double surchargeRate;

    public LuxurySurchargeDecorator(TaxContext wrapped, double surchargeRate) {
        super(wrapped);
        this.surchargeRate = surchargeRate;
    }

    @Override
    public double calculateTax() {
        double baseTax = wrapped.calculateTax();
        double extra = baseTax * surchargeRate;
        double total = baseTax + extra;
        System.out.println("Phu thu hang xa xi " + (surchargeRate * 100) + "%: " + extra + " => Tong thue: " + total);
        return total;
    }
}

