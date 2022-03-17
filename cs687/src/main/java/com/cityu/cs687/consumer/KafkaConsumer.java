package com.cityu.cs687.consumer;

import com.cityu.cs687.dto.CustomerInfoDto;
import com.cityu.cs687.model.CustomerInfo;
import com.cityu.cs687.repository.CustomerInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

  @Autowired
  private CustomerInfoRepository customerInfoRepository;

  @KafkaListener(topics = "cs687_topic", groupId = "am-id")
  public void listen(ConsumerRecord<String, CustomerInfo> record) {
    log.info("\nReceived Key: " + record.key());
    log.info("\nReceived Message: " + record.value());
    if (record.value() == null || !CustomerInfo.class.isInstance(record.value())) {
      log.error("Invalid message type");
      return;
    }
    var customerInfoDto=saveToDatabase(record.key(), record.value());
    log.info("\nSaved to DB " + customerInfoDto.getCorrelation_id());
  }

  /* Private method to save to Postgres Database*/
  private CustomerInfoDto saveToDatabase(String key, CustomerInfo value){
    CustomerInfoDto customerInfoDto= new CustomerInfoDto();
    try {
      customerInfoDto.setCorrelation_id(key);
      customerInfoDto.setFirst_name(value.getFirstName());
      customerInfoDto.setLast_name(value.getLastName());
      return customerInfoRepository.save(customerInfoDto);
    } catch (Exception ex){
      log.error("Failed in Saving to DB for the key: {}",key);
      throw ex;
    }
  }
}
