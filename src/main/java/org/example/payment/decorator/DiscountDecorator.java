package org.example.payment.decorator;

import org.example.payment.PaymentContext;

public class DiscountDecorator extends PaymentDecorator {
    private final double discountRate;

    public DiscountDecorator(PaymentContext wrapped, double discountRate) {
        super(wrapped);
        this.discountRate = discountRate;
    }

    @Override
    public boolean attemptPay() {
        double originalAmount = getAmount();
        double discount = originalAmount * discountRate;
        double total = originalAmount - discount;
        System.out.println("Ap dung giam gia " + (discountRate * 100) + "%: -" + discount + ", con: " + total);
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

