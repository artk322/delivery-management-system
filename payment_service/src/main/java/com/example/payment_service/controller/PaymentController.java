package com.example.payment_service.controller;

import com.example.payment_service.service.PaymentService;
import com.example.payment_service.service.iml.PaymentServiceImpl;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

  @Autowired
  PaymentService paymentService;

  @PostMapping
  public ResponseEntity<String> makePayment(@RequestBody ObjectNode json) {
//    paymentService.pay(price);
    System.out.println(json.get("price"));
    return ResponseEntity.ok("ok");
  }
}
