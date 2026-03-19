package org.example.order;

import org.example.order.GiftWrapDecorator;
import org.example.order.Order;
import org.example.order.InsuranceDecorator;
import org.example.order.refund.BankRefund;
import org.example.order.refund.MomoRefund;
import org.example.order.ship.FastShipping;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== KHỞI TẠO HỆ THỐNG QUẢN LÝ ĐƠN HÀNG ===\n");

        // 1. Tạo đơn hàng cơ bản
        Order order = new Order();
        order.setAmount(250_000);
        order.setRefundStrategy(new BankRefund());

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
        order.cancelOrder(); // Không hoàn tiền

        System.out.println("\n--- TẠO ĐƠN MỚI VÀ HỦY NGAY ---");
        Order order2 = new Order();
        order2.setAmount(150_000);
        order2.setRefundStrategy(new MomoRefund());
        order2.cancelOrder(); // Hủy ở trạng thái Mới tạo -> Hoàn tiền về Momo
        order2.nextStep(); // Thử bấm tiếp tục sau khi hủy
    }
}