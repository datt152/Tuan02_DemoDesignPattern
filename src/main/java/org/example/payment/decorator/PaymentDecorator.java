package org.example.payment.decorator;

import org.example.payment.PaymentContext;

public abstract class PaymentDecorator extends PaymentContext {
    protected final PaymentContext wrapped;

    protected PaymentDecorator(PaymentContext wrapped) {
        super(0, null);
        this.wrapped = wrapped;
    }

    @Override
    public void setState(org.example.payment.state.PaymentState state) {
        wrapped.setState(state);
    }

    @Override
    public void setStrategy(org.example.payment.strategy.PaymentStrategy strategy) {
        wrapped.setStrategy(strategy);
    }

    @Override
    public void setAmount(double amount) {
        wrapped.setAmount(amount);
    }

    @Override
    public boolean attemptPay() {
        return wrapped.attemptPay();
    }

    @Override
    public void process() {
        wrapped.process();
    }

    @Override
    public void displayInfo() {
        wrapped.displayInfo();
    }
}

