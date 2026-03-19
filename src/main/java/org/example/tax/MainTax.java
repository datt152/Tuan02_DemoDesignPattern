package org.example.tax;

import org.example.tax.decorator.EnvironmentalFeeDecorator;
import org.example.tax.decorator.LuxurySurchargeDecorator;
import org.example.tax.strategy.FlatTax;
import org.example.tax.strategy.LuxuryTax;
import org.example.tax.strategy.TaxStrategy;
import org.example.tax.strategy.VatTax;

public class MainTax {
    public static void main(String[] args) {
        System.out.println("=== DEMO TINH THUE (State + Strategy + Decorator) ===\n");

        // Base context: amount 1_000_000 with VAT 10%
        TaxStrategy vat10 = new VatTax(0.1);
        TaxContext context = new TaxContext(1_000_000, vat10);

        // Decorate with environmental fee and luxury surcharge
        context = new EnvironmentalFeeDecorator(context, 50_000);
        context = new LuxurySurchargeDecorator(context, 0.05);

        context.displayInfo();

        System.out.println("\n--- CHAY QUA CAC TRANG THAI ---");
        context.nextStep(); // Draft -> Calculated (calculates tax)
        context.nextStep(); // Calculated -> Filed
        context.nextStep(); // Already filed

        System.out.println("\n--- DOI CHIEN LUOC THUE & TINH LAI ---");
        context.setStrategy(new LuxuryTax(0.2));
        context.setAmount(2_000_000);
        context.nextStep(); // Filed -> no change, but we can still calculate directly
        context.calculateTax();

        System.out.println("\n--- CHIEN LUOC FIXED ---");
        context.setStrategy(new FlatTax(25_000));
        context.calculateTax();
    }
}

