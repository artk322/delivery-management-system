package com.example.couriers_service.controller;

import com.example.couriers_service.model.Courier;
import com.example.couriers_service.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourierController {

  @Autowired
  private CourierService courier_service;

//  @Autowired
//  private DiscoveryClient discoveryClient;
//
//  @Autowired
//  LoadBalancerClient loadBalancerClient;

  @PostMapping
  public ResponseEntity<Long> create_courier(Courier courier) {
    return ResponseEntity.ok(courier_service.create_courier(courier));
  }

  @GetMapping
  public ResponseEntity<List> get_all_couriers() {
    return ResponseEntity.ok(courier_service.get_all_couriers());
  }

  @PostMapping("/is_busy")
  public void set_is_busy(@RequestBody Long id, @RequestBody Boolean is_busy) {
    Courier courier = courier_service.get_courier_by_id(id);
    courier.setIs_busy(is_busy);
  }

//  @RequestMapping("/load-balance")
//  public String serverLocation(Model model) {
//    String serviceId = "REST-SERVER";
//
//    List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);
//
//    if (instances != null && !instances.isEmpty()) {
//      RestTemplate restTemplate = new RestTemplate();
//
//      model.addAttribute("serviceId", serviceId);
//      model.addAttribute("instances", instances);
//      try {
//        ServiceInstance serviceInstance = this.loadBalancerClient.choose(serviceId);
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort();
//        String result = restTemplate.getForObject(url, String.class);
//
//        model.addAttribute("url", url);
//        model.addAttribute("result", result);
//
//      } catch (IllegalStateException e) {
//        model.addAttribute("Error", e.getMessage());
//        e.printStackTrace();
//      }
//    }
//    return "index";
//  }
}
