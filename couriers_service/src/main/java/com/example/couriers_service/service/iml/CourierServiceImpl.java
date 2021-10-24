package com.example.couriers_service.service.iml;

import com.example.couriers_service.model.Courier;
import com.example.couriers_service.service.CourierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourierServiceImpl implements CourierService {
  private List<Courier> couriers = new ArrayList<>();

  @Override
  public Long create_courier(Courier courier) {
    couriers.add(courier);
    return courier.getId();
  }

  @Override
  public void take_order(Long courier_id, Long order_id) {
    Courier courier = get_courier_by_id(courier_id);
    courier.setCurrent_order_id(order_id);
  }

  @Override
  public List<Courier> get_all_couriers() {
    return couriers;
  }

  @Override
  public Courier get_courier_by_id(Long id) {
    for (Courier courier : couriers) {
      if (courier.getId() == id) {
        return courier;
      }
    }
    return null;
  }
}