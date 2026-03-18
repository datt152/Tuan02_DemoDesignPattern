package org.example.order;

public abstract class OrderDecorator extends Order{
    protected Order decoratedOrder;
    public OrderDecorator(Order order) {
        this.decoratedOrder = order;
    }
}
