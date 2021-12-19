package com.example.orders_service.controller;

import com.example.orders_service.model.Order;
import com.example.orders_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

  @Autowired
  private OrderService order_service;

  @PostMapping
  public ResponseEntity<Long> create_order(Order order) {
    return ResponseEntity.ok(order_service.create_order(order));
  }

  @GetMapping
  public ResponseEntity<List> get_all_orders() {
    return ResponseEntity.ok(order_service.get_all_orders());
  }

  @GetMapping("/status/{id}")
  public ResponseEntity<String> get_order_status(@PathVariable Long id) {
    return ResponseEntity.ok(order_service.get_order_status(id));
  }
  @PostMapping("/status/{id}")
  public ResponseEntity<String> order_set_status(@PathVariable Long id, @RequestBody String status) {
    order_service.set_order_status(id, status);
    return ResponseEntity.ok("ok");
  }

  @GetMapping("/customer/{id}")
  public ResponseEntity<List> get_order_by_customer_id(@PathVariable Long id) {
    return ResponseEntity.ok(order_service.get_orders_by_customer_id(id));
  }
  @GetMapping("/courier/{id}")
  public ResponseEntity<List> get_order_by_courier_id(@PathVariable Long id) {
    return ResponseEntity.ok(order_service.get_orders_by_customer_id(id));
  }
}
