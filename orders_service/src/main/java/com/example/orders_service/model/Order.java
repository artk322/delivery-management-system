package com.example.orders_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
  private Long id;
  private Long courier_id;
  private Long customer_id;
  private Long product_id;
  private Long feedback_id;
  private String status = "preparing"; // delivering, cooking, finished
  private Boolean is_paid = false;
  private String details; // what to bring, from - to
  private int amount;
  private Double price;
  private String name;
}
