package com.example.couriers_service.controller;

import com.example.couriers_service.model.Courier;
import com.example.couriers_service.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courier")
public class CourierController {

  @Autowired
  private CourierService courier_service;

  @PostMapping
  public ResponseEntity<Long> create_courier(@RequestBody Courier courier) {
    return ResponseEntity.ok(courier_service.create_courier(courier));
  }

  @GetMapping
  public ResponseEntity<List> get_all_couriers() {
    return ResponseEntity.ok(courier_service.get_all_couriers());
  }
}
