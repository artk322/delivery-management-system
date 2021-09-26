package com.example.orders_service.service;

import com.example.orders_service.model.Order;

import java.util.List;

public interface OrderService {
  Long create_order(Order order);

  List<Order> get_all_orders();

  List<Order> get_orders_by_status(String status);

  List<Order> get_orders_by_customer_id(Long id);

  void complete_order_by_id(Long id);
}
