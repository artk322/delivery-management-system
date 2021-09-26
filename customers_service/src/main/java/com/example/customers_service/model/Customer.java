package com.example.customers_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
  private Long id;
  private String email;
  private String password;
  private String name;
  private String address;
  private Double balance;
}
