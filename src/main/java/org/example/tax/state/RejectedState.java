package org.example.tax.state;

import org.example.tax.TaxContext;

public class RejectedState implements TaxState {
    @Override
    public void handle(TaxContext context) {
        System.out.println("Rejected -> Draft");
        context.setState(new DraftState());
    }

    @Override
    public String getStatus() {
        return "Rejected";
    }
}

