package org.example.order.refund;

public class BankRefund implements RefundStrategy{

    @Override
    public void refund(double amount) {
        System.out.println("Hoàn tiền về ngân hàng");
    }
}
