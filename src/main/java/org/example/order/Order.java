package org.example.order;

import org.example.order.ship.ShippingStrategy;
import org.example.order.ship.StandardShipping;
import org.example.order.state.NewOrderState;
import org.example.order.state.OrderState;
import org.example.order.state.ProcessingState;

public class Order {
    private OrderState state;
    private ShippingStrategy shippingStrategy;

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
    }
}
