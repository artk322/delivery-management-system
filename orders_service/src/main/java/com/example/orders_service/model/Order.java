package com.example.orders_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
  private Long id;
  private Long courier_id;
  private Long customer_id;
  private Double price;
  private String status; // delivering, cooking, finished
  private Boolean is_paid;
  private String details; // what to bring, from - to
}
