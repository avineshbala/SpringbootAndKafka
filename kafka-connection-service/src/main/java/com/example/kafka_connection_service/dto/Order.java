package com.example.kafka_connection_service.dto;

import lombok.Data;

@Data
public class Order {
    public String name;
    public String orderItem;
    public int orderId;
}
