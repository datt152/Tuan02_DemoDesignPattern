package org.example.tax.state;

import org.example.tax.TaxContext;

public interface TaxState {
    void handle(TaxContext context);
    String getStatus();
}

