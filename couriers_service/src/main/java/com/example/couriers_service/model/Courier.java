package com.example.couriers_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Courier {
  private Long id;
  private Boolean is_busy;
  private String name;
  private String phone_number;
  private Long current_order_id;
}
