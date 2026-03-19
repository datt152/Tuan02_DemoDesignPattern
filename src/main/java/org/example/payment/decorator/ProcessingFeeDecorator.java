package org.example.payment.decorator;

import org.example.payment.PaymentContext;

public class ProcessingFeeDecorator extends PaymentDecorator {
    private final double feeRate;

    public ProcessingFeeDecorator(PaymentContext wrapped, double feeRate) {
        super(wrapped);
        this.feeRate = feeRate;
    }

    @Override
    public boolean attemptPay() {
        double originalAmount = getAmount();
        double fee = originalAmount * feeRate;
        double total = originalAmount + fee;
        System.out.println("Phi xu ly " + (feeRate * 100) + "%: " + fee + ", tong thanh toan: " + total);
        setAmount(total);
        boolean result = wrapped.attemptPay();
        setAmount(originalAmount); // restore
        return result;
    }

    private double getAmount() {
        try {
            java.lang.reflect.Field f = PaymentContext.class.getDeclaredField("amount");
            f.setAccessible(true);
            return (double) f.get(wrapped);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public void setAmount(double amount) {
        try {
            java.lang.reflect.Field f = PaymentContext.class.getDeclaredField("amount");
            f.setAccessible(true);
            f.set(wrapped, amount);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}

