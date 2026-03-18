package org.example.order.refund;

public class MomoRefund implements RefundStrategy{

    @Override
    public void refund(double amount) {
        System.out.println("Hoàn tiền về momo");
    }
}
