package com.example.productsservice.service.impl;

import com.example.productsservice.model.Product;
import com.example.productsservice.service.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductServiceImpl implements ProductService {
  private List<Product> products = Arrays.asList(
      new Product(1L, "Burger", 500),
      new Product(2L, "Burger", 500),
      new Product(3L, "Burger", 500)
  );

  @Override
  public List<Product> get_all_products() {
    return products;
  }
}
