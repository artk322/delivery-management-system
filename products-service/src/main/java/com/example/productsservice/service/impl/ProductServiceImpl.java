package com.example.productsservice.service.impl;

import com.example.productsservice.model.Product;
import com.example.productsservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
  private List<Product> products = Arrays.asList(
      new Product(1L, "Hamburger", 700),
      new Product(2L, "CheeseBurger", 800),
      new Product(3L, "French fries", 400),
      new Product(4L, "Hot-Dog", 750),
      new Product(5L, "Coca-Cola", 200),
      new Product(6L, "FuseTea", 200),
          new Product(7L, "Coffee", 400),
      new Product(8L, "Tea", 250),
      new Product(9L, "Chicken strips", 800),
      new Product(10L, "Chicken wings", 900),
      new Product(11L, "Nuggets", 750),
      new Product(12L, "Chicken popcorn", 550),
      new Product(13L, "Ice cream", 300)
  );

  @Override
  public List<Product> get_all_products() {
    return products;
  }
}
