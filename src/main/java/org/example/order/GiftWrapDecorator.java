package org.example.order;

public class GiftWrapDecorator extends OrderDecorator {
    public GiftWrapDecorator(Order order) {
        super(order);
    }

    @Override
    public void displayInfo() {
        decoratedOrder.displayInfo();
        System.out.println("Tang them goi qua 20k");
    }
}
