package com.example.kafkatest.controller;

import com.example.kafkatest.entity.AlarmIn;
import com.example.kafkatest.kafka.Producer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.kafkatest.config.KafkaConfig.TOPIC_ALARM_IN;

@RestController
public class SendMessageController {

    @Autowired
    private Producer producer;

    @PostMapping("/send")
    public String send(@RequestBody AlarmIn alarmIn){
        System.out.println("\n------------------------------------");
        String topic = TOPIC_ALARM_IN;
        String key = alarmIn.getId().toString();
        try {
            String jsonStr = new ObjectMapper().writeValueAsString(alarmIn);
            producer.sendMsg(topic, key, jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "OK";
    }

}
