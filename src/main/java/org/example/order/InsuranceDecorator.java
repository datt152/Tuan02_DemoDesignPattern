package org.example.order;

import org.example.order.Order;
import org.example.order.OrderDecorator;

public class InsuranceDecorator extends OrderDecorator {
    public InsuranceDecorator(Order order) {
        super(order);
    }

    @Override
    public void displayInfo() {
        decoratedOrder.displayInfo();
        System.out.println("Bao hiem de vo 5k");
    }
}
