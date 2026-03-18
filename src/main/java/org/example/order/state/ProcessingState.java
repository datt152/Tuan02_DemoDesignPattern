package org.example.order.state;

import org.example.order.Order;

public class ProcessingState implements OrderState {
    @Override
    public void handle(Order context) {
        System.out.println("2. Dang dong goi va lien he van chuyen");
        context.getState(new DeliveredState());
    }

    @Override
    public String getStatusName() {
        return "Dang xu ly";
    }

    @Override
    public void cancel(Order context) {
        System.out.println("Huy don hang trong qua trinh xu ly");
        context.getState(new CancelState());
    }
}
