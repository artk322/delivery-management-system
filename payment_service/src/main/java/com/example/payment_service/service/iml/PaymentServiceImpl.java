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
  public void pay() {
    //
//    restTemplate.getForObject()
//    restTemplate.postForLocation("http://customer_service/customer/balance");
  }
}
