package org.example.tax.state;

import org.example.tax.TaxContext;

public class CalculatedState implements TaxState {
    @Override
    public void handle(TaxContext context) {
        System.out.println("Calculated -> Filed");
        context.setState(new FiledState());
    }

    @Override
    public String getStatus() {
        return "Calculated";
    }
}

