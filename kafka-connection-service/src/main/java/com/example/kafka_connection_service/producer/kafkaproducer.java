package com.example.kafka_connection_service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service

public class kafkaproducer {

    int counter = 0;
    @Autowired KafkaTemplate<String, String> kafkatemplate;

    public void sendMessage(String message){
        kafkatemplate.send("kafkaproducertopic","This is Test Kafka Producer");
    }

    public void sendMessagePartition(String message){
        counter++;
        kafkatemplate.send("kafkaproducertopic", String.valueOf(counter), "This is Kafka Partition Logic message");
    }

}
