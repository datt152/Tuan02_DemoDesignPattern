package org.example.payment.state;

import org.example.payment.PaymentContext;

public class FailedState implements PaymentState {
    @Override
    public void handle(PaymentContext context) {
        System.out.println("Thanh toan that bai, vui long thu lai");
    }

    @Override
    public String getStatus() {
        return "Failed";
    }
}

