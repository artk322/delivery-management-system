package com.example.payment_service.controller;

import com.example.payment_service.service.PaymentService;
import com.example.payment_service.service.iml.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

  @Autowired
  PaymentService paymentService;


  @PostMapping
  public ResponseEntity<String> makePayment(Double price) {
    paymentService.pay(price);
    return ResponseEntity.ok("ok");
  }
}
