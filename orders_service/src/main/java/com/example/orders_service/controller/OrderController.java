package com.example.orders_service.controller;

import com.example.orders_service.model.Order;
import com.example.orders_service.service.OrderService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

  @Autowired
  private OrderService order_service;

  @PostMapping
  public ResponseEntity<Long> create_order(@RequestBody Order order) {
    return ResponseEntity.ok(order_service.create_order(order));
  }

  @GetMapping
  public ResponseEntity<List> get_all_orders() {
    return ResponseEntity.ok(order_service.get_all_orders());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Order> get_order_by_id(@PathVariable Long id) {
    return ResponseEntity.ok(order_service.get_order_by_id(id));
  }

  @GetMapping("/status/{id}")
  public ResponseEntity<String> get_order_status(@PathVariable Long id) {
    return ResponseEntity.ok(order_service.get_order_status(id));
  }
  @PostMapping("/status/{id}")
  public ResponseEntity<String> order_set_status(@PathVariable Long id, @RequestBody ObjectNode json) {
    order_service.set_order_status(id, json.get("status").asText());
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

  @PostMapping("/assign/courier/{id}")
  public ResponseEntity<String> assign_courier_id(@PathVariable Long id, @RequestBody ObjectNode json) {
    order_service.assign_courier_id(id, json.get("id").asLong());
    return ResponseEntity.ok("ok");
  }
  @PostMapping("/assign/customer/{id}")
  public ResponseEntity<String> assign_customer_id(@PathVariable Long id, @RequestBody ObjectNode json) {
    order_service.assign_customer_id(id, json.get("id").asLong());
    return ResponseEntity.ok("ok");
  }
  @PostMapping("/assign/feedback/{id}")
  public ResponseEntity<String> assign_feedback_id(@PathVariable Long id, @RequestBody ObjectNode json) {
    order_service.assign_feedback_id(id, json.get("id").asLong());
    return ResponseEntity.ok("ok");
  }
}
