package com.example.payment_service.service.iml;

import com.example.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentServiceImpl implements PaymentService {

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public void pay(Double price) {
    String customer_url = restTemplate.getForObject("http://localhost:8085/get-load-balance/customer_service", String.class);
    restTemplate.postForLocation(customer_url, price);
  }
}
