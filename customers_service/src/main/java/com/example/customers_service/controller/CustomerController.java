package com.example.customers_service.controller;

import com.example.customers_service.model.Customer;
import com.example.customers_service.service.CustomerService;
import com.example.customers_service.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  private CustomerService customer_service;

  @Autowired
  private KafkaService kafkaService;

  @PostMapping
  public ResponseEntity<Long> add_customer(@RequestBody Customer customer) {
    return ResponseEntity.ok(customer_service.add_customer(customer));
  }
  @GetMapping("/{id}")
  public ResponseEntity<Customer> get_customer_by_id(@PathVariable Long id) {
    return ResponseEntity.ok(customer_service.get_customer_by_id(id));
  }

  @GetMapping
  public ResponseEntity<List> get_customers() {
    return ResponseEntity.ok(customer_service.get_all_customers());
  }

  @PostMapping("/balance")
  public ResponseEntity<Double> set_balance(Long id, Double balance) {
    Customer customer = customer_service.get_customer_by_id(id);
    customer.setBalance(balance);
    return ResponseEntity.ok(customer.getBalance());
  }

  @GetMapping("/producer")
  public String producer(@RequestParam("message") String message) {
    kafkaService.send(message);
    return "Message sent to the Kafka Topic java_in_use_topic Successfully";
  }
}
