package org.example.order.state;

import org.example.order.Order;
import org.example.order.refund.RefundStrategy;

public class CancelState implements OrderState {

    @Override
    public void handle(Order context) {
        System.out.println("Don hang da huy");
    }

    @Override
    public String getStatusName() {
        return "Da huy";
    }

    @Override
    public void cancel(Order context) {
        System.out.println("Don hang von da huy");
    }
}
