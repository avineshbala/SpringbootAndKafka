package com.example.kafka_connection_service.serializer;

import java.io.IOException;
import java.util.Map;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import com.example.kafka_connection_service.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserSerializer implements Serializer<User>, Deserializer<User>{
    ObjectMapper mapper = new ObjectMapper();
    @Override
    public byte[] serialize(String topic, User data) {
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
    public User deserialize(String topic, byte[] data) {
         try{
            return mapper.readValue(data, User.class);
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
