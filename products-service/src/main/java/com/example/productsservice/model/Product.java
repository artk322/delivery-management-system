package com.example.productsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
  private Long id;
  private String name;
  private double price;
}
