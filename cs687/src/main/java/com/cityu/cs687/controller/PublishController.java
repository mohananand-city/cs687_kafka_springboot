package com.cityu.cs687.controller;


import com.cityu.cs687.model.CustomerInfo;
import com.cityu.cs687.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class PublishController {

  private final KafkaProducer kafkaProducer;

  @Autowired
  PublishController(KafkaProducer kafkaProducer){
    this.kafkaProducer=kafkaProducer;
  }

  @PostMapping(value = "/publish")
  public void sendMessageToKafkaTopic(@RequestBody CustomerInfo message){
    this.kafkaProducer.sendMessage(message);
  }


}
