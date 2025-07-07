package com.example.kafka_connection_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka_connection_service.producer.kafkaproducer;

@RestController
@RequestMapping("/kafka")
public class kafkaController {

    @Autowired kafkaproducer sendMsg;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        sendMsg.sendMessage("Hello");
        return "Kafka Message is posted";
    }

     @GetMapping("/sendPartitionMessage")
    public String sendPartitionMessage(){
        sendMsg.sendMessagePartition("Hello");
        return "Kafka Message is posted";
    }

}
