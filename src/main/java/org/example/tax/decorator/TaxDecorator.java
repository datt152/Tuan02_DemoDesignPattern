package org.example.tax.decorator;

import org.example.tax.TaxContext;

public abstract class TaxDecorator extends TaxContext {
    protected final TaxContext wrapped;

    protected TaxDecorator(TaxContext wrapped) {
        super(0, null);
        this.wrapped = wrapped;
    }

    @Override
    public void setState(org.example.tax.state.TaxState state) {
        wrapped.setState(state);
    }

    @Override
    public void setStrategy(org.example.tax.strategy.TaxStrategy strategy) {
        wrapped.setStrategy(strategy);
    }

    @Override
    public void setAmount(double amount) {
        wrapped.setAmount(amount);
    }

    @Override
    public double calculateTax() {
        return wrapped.calculateTax();
    }

    @Override
    public void nextStep() {
        wrapped.nextStep();
    }

    @Override
    public void displayInfo() {
        wrapped.displayInfo();
    }
}

