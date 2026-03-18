package org.example.order.state;

import org.example.order.Order;

public interface OrderState {
    void handle(Order context);
    String getStatusName();
    void cancel(Order context);
}
