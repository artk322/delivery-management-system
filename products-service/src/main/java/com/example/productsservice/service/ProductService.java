package com.example.productsservice.service;

import com.example.productsservice.model.Product;

import java.util.List;

public interface ProductService {
  List<Product> get_all_products();
  Product get_product_by_id(Long id);


}
