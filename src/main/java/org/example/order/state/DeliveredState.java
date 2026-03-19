package org.example.order.state;

import org.example.order.Order;

public class DeliveredState implements OrderState {
    @Override
    public void handle(Order context) {
        System.out.println("3. Da giao hang thanh cong");
    }

    @Override
    public String getStatusName() {
        return "Da giao";
    }
    @Override
    public void cancel(Order context) {
        System.out.println("Khong the huy don hang da giao");
    }
}
