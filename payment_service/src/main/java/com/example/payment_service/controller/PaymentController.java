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
@CrossOrigin
public class PaymentController {

  @Autowired
  PaymentService paymentService;

  @PostMapping
  public ResponseEntity<String> makePayment(@RequestBody ObjectNode json) {
//    paymentService.pay(json.get());
    //System.out.println(json.get("price"));
    //Customer cust = json.get("cust_id");
    //newBalance = json.get("cust_id");
    return ResponseEntity.ok("ok");
  }
}
