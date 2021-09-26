package com.example.couriers_service.service;

import com.example.couriers_service.model.Courier;

import java.util.List;

public interface CourierService {
  Long create_courier(Courier courier);

  List<Courier> get_all_couriers();

  void take_order(Long courier_id, Long order_id);

  Courier get_courier_by_id(Long id);
}
