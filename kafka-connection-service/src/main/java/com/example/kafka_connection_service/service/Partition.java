package com.example.kafka_connection_service.service;

import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

public class Partition implements Partitioner{

    @Override
    public void configure(Map<String, ?> configs) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        // TODO Auto-generated method stub
        int numPartitions = cluster.partitionCountForTopic(topic);
        System.out.println("======= Partition Num===========" + numPartitions);
        int keyNum = Integer.valueOf((String)key);
        System.out.println("======= Key Num===========" + keyNum%numPartitions);
        return keyNum%numPartitions;

       
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        
    }

}
