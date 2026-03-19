package org.example.payment.state;

import org.example.payment.PaymentContext;

public interface PaymentState {
    void handle(PaymentContext context);
    String getStatus();
}

