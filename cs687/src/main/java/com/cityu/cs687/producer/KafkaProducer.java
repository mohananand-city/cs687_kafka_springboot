package com.cityu.cs687.producer;

import com.cityu.cs687.model.CustomerInfo;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaProducer {
  private final String TOPIC="cs687_topic";

  private final KafkaTemplate<String, CustomerInfo> kafkaTemplate;

  @Autowired
  public KafkaProducer (KafkaTemplate<String,CustomerInfo> kafkaTemplate){
    this.kafkaTemplate=kafkaTemplate;
  }

  public void sendMessage(CustomerInfo message){
    String key= UUID.randomUUID().toString();
    final ProducerRecord<String, CustomerInfo> record= new ProducerRecord<>(TOPIC, null,key,message);
    kafkaTemplate.send(record);
    log.info("\nPublished message to Kafka successfully with:\nkey: {}\nMessage: \n{}",key,message);
  }

}
