package com.example.kafka_connection_service.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaconsumer {

    @KafkaListener(topics = "kafkaproducertopic", groupId = "my-consumer-group")
    public void consumeMessageFromTopic(ConsumerRecord<String,String> message){
        System.out.println(message);
    }


}
