package org.example.order;

import org.example.order.refund.RefundStrategy;
import org.example.order.ship.ShippingStrategy;
import org.example.order.ship.StandardShipping;
import org.example.order.state.NewOrderState;
import org.example.order.state.OrderState;
import org.example.order.state.ProcessingState;

public class Order {
    private OrderState state;
    private ShippingStrategy shippingStrategy;
    private RefundStrategy refundStrategy;
    private double amount;

    public Order() {
        this.state = new NewOrderState();
        this.shippingStrategy = new StandardShipping();
    }

    public void getState(OrderState state) {
        this.state = state;
        System.out.println("Chuyen trang thai sang: " + state.getStatusName());
    }
    public void setShippingStrategy(ShippingStrategy strategy) {
        this.shippingStrategy = strategy;
    }
    public void setRefundStrategy(RefundStrategy refundStrategy) {
        this.refundStrategy = refundStrategy;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void refund() {
        if (refundStrategy == null) {
            System.out.println("Khong co phuong thuc hoan tien");
            return;
        }
        refundStrategy.refund(amount);
    }
    public void nextStep() {
        state.handle(this);
        if(state instanceof ProcessingState) {
            shippingStrategy.ship();
        }
    }
    public void cancelOrder() {
        state.cancel(this);
    }
    public void displayInfo() {
        System.out.println("Don hang #123");
        if (amount > 0) {
            System.out.println("Gia tri don: " + amount);
        }
    }
}
