package org.example.tax.state;

import org.example.tax.TaxContext;

public class FiledState implements TaxState {
    @Override
    public void handle(TaxContext context) {
        System.out.println("Tax already filed");
    }

    @Override
    public String getStatus() {
        return "Filed";
    }
}

