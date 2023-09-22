package com.example.kafkatest.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaSendResultHandler kafkaSendResultHandler;

    public void sendMsg(String topic, String key, String value) {
        try{
            // 设置消息发送结果的回调
            kafkaTemplate.setProducerListener(kafkaSendResultHandler);
            kafkaTemplate.send(topic, key, value);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
