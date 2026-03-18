package org.example.order.ship;

public class StandardShipping implements ShippingStrategy{
    @Override
    public void ship() {
        System.out.println("Giao hang tieu chuan, 3-5 ngay");
    }
}
