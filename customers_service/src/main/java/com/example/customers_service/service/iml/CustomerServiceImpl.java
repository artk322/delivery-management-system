package com.example.customers_service.service.iml;

import com.example.customers_service.model.Customer;
import com.example.customers_service.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
  private List<Customer> customers = new ArrayList<>();

  @Override
  public List<Customer> get_all_customers() {
    return customers;
  }

  @Override
  public Long add_customer(Customer customer) {
    customers.add(customer);
    return customer.getId();
  }

  @Override
  public Customer get_customer_by_id(long id) {
    for (Customer customer : customers) {
      if (customer.getId() == id) {
        return customer;
      }
    }
    return null;
  }
}
