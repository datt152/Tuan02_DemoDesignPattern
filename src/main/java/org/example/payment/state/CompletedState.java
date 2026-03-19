package org.example.payment.state;

import org.example.payment.PaymentContext;

public class CompletedState implements PaymentState {
    @Override
    public void handle(PaymentContext context) {
        System.out.println("Thanh toan da hoan tat");
    }

    @Override
    public String getStatus() {
        return "Completed";
    }
}

