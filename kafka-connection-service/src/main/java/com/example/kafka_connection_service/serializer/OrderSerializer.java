package com.example.kafka_connection_service.serializer;

import java.io.IOException;
import java.util.Map;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.stereotype.Component;

import com.example.kafka_connection_service.dto.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class OrderSerializer implements Serializer<Order>, Deserializer<Order>{
    ObjectMapper mapper = new ObjectMapper();
    @Override
    public byte[] serialize(String topic, Order data) {
        // TODO Auto-generated method stub
        try{
            System.out.println("===================================================================");
            System.out.println("Serializing data");
            return mapper.writeValueAsBytes(data);
        }
         catch(JsonProcessingException e){
		throw new SerializationException(e);
        }
    
    }

    @Override
    public Order deserialize(String topic, byte[] data) {
         try{
            return mapper.readValue(data, Order.class);
        }
        catch(IOException e){
            throw new SerializationException(e);
        }
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

}
