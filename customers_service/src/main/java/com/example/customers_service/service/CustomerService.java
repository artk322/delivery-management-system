package com.example.customers_service.service;

import com.example.customers_service.model.Customer;

import java.util.List;

public interface CustomerService {
  Long add_customer(Customer customer);

  Customer get_customer_by_id(long id);

  List<Customer> get_all_customers();
}
