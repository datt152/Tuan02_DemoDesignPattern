package org.example.order.ship;

public class FastShipping implements ShippingStrategy{
    @Override
    public void ship() {
        System.out.println("Giao hoa toc");

    }
}
