package org.example.tax.state;

import org.example.tax.TaxContext;

public class DraftState implements TaxState {
    @Override
    public void handle(TaxContext context) {
        System.out.println("Draft -> Calculated");
        context.setState(new CalculatedState());
        context.calculateTax();
    }

    @Override
    public String getStatus() {
        return "Draft";
    }
}

