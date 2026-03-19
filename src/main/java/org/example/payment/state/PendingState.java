package org.example.payment.state;

import org.example.payment.PaymentContext;

public class PendingState implements PaymentState {
    @Override
    public void handle(PaymentContext context) {
        System.out.println("Dang xu ly thanh toan");
        if (context.attemptPay()) {
            context.setState(new CompletedState());
        } else {
            context.setState(new FailedState());
        }
    }

    @Override
    public String getStatus() {
        return "Pending";
    }
}

