package com.example.ribbon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.ServiceInstanceChooser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class RibbonController {

  @Autowired
  DiscoveryClient discoveryClient;

  @Autowired
  LoadBalancerClient loadBalancerClient;

  @RequestMapping("/load-balance/{serviceId}")
  public String serverLocation(Model model, @PathVariable String serviceId) {

    List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);

    if (instances != null && !instances.isEmpty()) {
      RestTemplate restTemplate = new RestTemplate();

      model.addAttribute("serviceId", serviceId);
      model.addAttribute("instances", instances);
      try {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose(serviceId);
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort();

        model.addAttribute("url", url);

      } catch (IllegalStateException e) {
        model.addAttribute("Error", e.getMessage());
        e.printStackTrace();
      }
    }
    return "index";
  }

  @ResponseBody
  @RequestMapping("/get-load-balance/{serviceId}")
  public ResponseEntity<String> getServerLocation(@PathVariable String serviceId) {
    try {
      ServiceInstance serviceInstance = this.loadBalancerClient.choose(serviceId);
      String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort();
      return ResponseEntity.ok(url);
    } catch (IllegalStateException e) {
      return ResponseEntity.ok(e.getMessage());
    }
  }
}
