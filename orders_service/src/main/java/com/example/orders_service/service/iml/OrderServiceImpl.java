package com.example.orders_service.service.iml;

import com.example.orders_service.model.Order;
import com.example.orders_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
  private List<Order> orders = new ArrayList<>();
  
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public void complete_order_by_id(Long id) {
    Order order = get_orders_by_id(id);
    order.setStatus("completed");
    String courier_url = restTemplate.getForObject("http://localhost:8085/get-load-balance/couriers_service", String.class);
    restTemplate.postForLocation(courier_url + "/courier/is_busy", order.getCourier_id(), false);
  }

  @Override
  @HystrixCommand(fallbackMethod = "requestFailedFallback")
  public Long create_order(Order order) {
    order.setStatus("in_progress");
    String payment_url = restTemplate.getForObject("http://localhost:8085/get-load-balance/payment_service", String.class);
    restTemplate.postForLocation(payment_url+ "/payment", order.getPrice());
    orders.add(order);
    return order.getId();
  }

  @Override
  @HystrixCommand(fallbackMethod = "requestFailedFallback")
  public List<Order> get_all_orders() {
    return orders;
  }

  @Override
  @HystrixCommand(fallbackMethod = "requestFailedFallback")
  public List<Order> get_orders_by_customer_id(Long id) {
    List<Order> filtered_orders = new ArrayList<>();
    for (Order order : orders) {
      if (order.getCustomer_id() == id) {
        filtered_orders.add(order);
      }
    }
    return filtered_orders;
  }

  @Override
  @HystrixCommand(fallbackMethod = "requestFailedFallback")
  public List<Order> get_orders_by_status(String status) {
    List<Order> filtered_orders = new ArrayList<>();
    for (Order order : orders) {
      if (order.getStatus().equals(status)) {
        filtered_orders.add(order);
      }
    }
    return filtered_orders;
  }

  public Order get_orders_by_id(Long id) {
    for (Order order : orders) {
      if (order.getId() == id) {
        return order;
      }
    }
    return null;
  }

  private String requestFailedFallback() {
    return "Request failed";
  }
}
