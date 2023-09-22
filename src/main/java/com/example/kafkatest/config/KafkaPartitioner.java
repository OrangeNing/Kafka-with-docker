package com.example.kafkatest.config;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class KafkaPartitioner implements Partitioner {

    @Override
    public void configure(Map<String, ?> configs) {
    }

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {

        // 获取该主题的分区数量
        int size = cluster.partitionsForTopic(topic).size();
        // 分区号
        int index = -1;
        switch ( (String) key) {
            case "996":
                index = 1;
                break;
            case "247":
                index = 2;
                break;
            case "965":
                index = 3;
                break;
            default:
                index = 0;
        }

        return index;
    }

    @Override
    public void close() {
    }
}
