package org.example.order.state;

import org.example.order.Order;

public class NewOrderState implements OrderState {

    @Override
    public void handle(Order context) {
        System.out.println("Kiem tra thong tin don hang va xac nhan thanh toan");
        context.getState(new ProcessingState());

    }

    @Override
    public String getStatusName() {
        return "Moi tao";
    }
    @Override
    public void cancel(Order context) {
        System.out.println("Huy don hang theo yeu cau");
        context.getState(new CancelState());
    }
}
