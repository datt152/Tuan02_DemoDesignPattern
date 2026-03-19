package org.example.payment;

import org.example.payment.decorator.DiscountDecorator;
import org.example.payment.decorator.ProcessingFeeDecorator;
import org.example.payment.strategy.CreditCardPayment;
import org.example.payment.strategy.PaypalPayment;

public class MainPayment {
    public static void main(String[] args) {
        System.out.println("=== DEMO THANH TOAN (State + Strategy + Decorator) ===\n");

        // Thanh toan 1: Credit card, có phí xử lý và giảm giá
        PaymentContext payment1 = new PaymentContext(1_000_000, new CreditCardPayment("4111-2222-3333-4444"));
        payment1 = new ProcessingFeeDecorator(payment1, 0.02); // +2%
        payment1 = new DiscountDecorator(payment1, 0.05); // -5%
        payment1.displayInfo();
        payment1.process(); // Pending -> Completed/Failed

        System.out.println("\n--- Thanh toan 2: PayPal, chỉ giảm giá ---");
        PaymentContext payment2 = new PaymentContext(500_000, new PaypalPayment("user@example.com"));
        payment2 = new DiscountDecorator(payment2, 0.10); // -10%
        payment2.displayInfo();
        payment2.process();
    }
}

