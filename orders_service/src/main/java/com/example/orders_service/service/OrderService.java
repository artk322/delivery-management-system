package com.example.orders_service.service;

import com.example.orders_service.model.Order;

import java.util.List;

public interface OrderService {
  Long create_order(Order order);

  List<Order> get_all_orders();
  Order get_order_by_id();

  List<Order> get_orders_by_customer_id(Long id);
  List<Order> get_orders_by_courier_id(Long id);

  String get_order_status(Long id);
  void set_order_status(String status);

  void assign_feedback_id(Long order_id, Long feedback_id);
  void assign_courier_id(Long order_id, Long courier_id);
  void assign_customer_id(Long order_id, Long customer_id);

  void complete_order_by_id(Long id);
}
