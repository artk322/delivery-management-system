package com.example.orders_service.service.iml;

import com.example.orders_service.model.Order;
import com.example.orders_service.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
//    restTemplate.postForLocation(payment_url+ "/payment", order.getPrice());
    orders.add(order);
    return order.getId();
  }

  @Override
  @HystrixCommand(fallbackMethod = "requestFailedFallback")
  public List<Order> get_all_orders() {
    return orders;
  }

  @Override
  public Order get_order_by_id(Long id) {
    Order target_order = null;
    for (Order order : orders) {
      if (order.getId() == id) {
        target_order = order;
      }
    }
    return target_order;
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
  public List<Order> get_orders_by_courier_id(Long id) {
    List<Order> filtered_orders = new ArrayList<>();
    for (Order order : orders) {
      if (order.getCourier_id() == id) {
        filtered_orders.add(order);
      }
    }
    return filtered_orders;
  }

  @Override
  public String get_order_status(Long id) {
    Order order = get_order_by_id(id);
    return order.getStatus();
  }

  @Override
  public void set_order_status(Long id, String status) {
    Order order = get_order_by_id(id);
    order.setStatus(status);
  }

  @Override
  public void assign_feedback_id(Long order_id, Long feedback_id) {
    Order order = get_order_by_id(order_id);
    order.setFeedback_id(feedback_id);
  }

  @Override
  public void assign_courier_id(Long order_id, Long courier_id) {
    Order order = get_order_by_id(order_id);
    order.setCourier_id(courier_id);
  }

  @Override
  public void assign_customer_id(Long order_id, Long customer_id) {
    Order order = get_order_by_id(order_id);
    order.setCustomer_id(customer_id);
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
