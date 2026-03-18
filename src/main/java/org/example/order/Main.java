package org.example.order;

import org.example.order.GiftWrapDecorator;
import org.example.order.Order;
import org.example.order.InsuranceDecorator;
import org.example.order.ship.FastShipping;
;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== KHỞI TẠO HỆ THỐNG QUẢN LÝ ĐƠN HÀNG ===\n");

        // 1. Tạo đơn hàng cơ bản
        Order order = new Order();

        // 2. Decorator: Thêm quà tặng và bảo hiểm
        order = new GiftWrapDecorator(order);
        order = new InsuranceDecorator(order);

        // 3. Strategy: Chọn giao hàng hỏa tốc
        order.setShippingStrategy(new FastShipping());

        // 4. Hiển thị thông tin
        order.displayInfo();

        // 5. Mô phỏng quy trình State
        System.out.println("\n--- BẮT ĐẦU QUY TRÌNH XỬ LÝ ---");
        order.nextStep(); // Từ Mới tạo -> Đang xử lý
        order.nextStep(); // Từ Đang xử lý -> Đã giao

        System.out.println("\n--- THỬ NGHIỆM HỦY ĐƠN KHI ĐÃ GIAO ---");
        order.cancelOrder();

        System.out.println("\n--- TẠO ĐƠN MỚI VÀ HỦY NGAY ---");
        Order order2 = new Order();
        order2.cancelOrder();
        order2.nextStep(); // Thử bấm tiếp tục sau khi hủy
    }
}