package com.example.customers_service.service.iml;

import com.example.customers_service.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements KafkaService {
  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;
  String kafkaTopic = "java_in_use_topic";

  @Override
  public void send(String message) {
    kafkaTemplate.send(kafkaTopic, message);
  }
}
