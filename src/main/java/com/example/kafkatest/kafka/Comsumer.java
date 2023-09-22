package com.example.kafkatest.kafka;

import com.example.kafkatest.entity.AlarmIn;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.example.kafkatest.config.KafkaConfig.TOPIC_ALARM_IN;

@Component
public class Comsumer {
    @KafkaListener(topics = TOPIC_ALARM_IN, groupId = "myGroup1" )
    public void g1c1(ConsumerRecord<String, String> record) {
        AlarmIn alarmIn = parseAlarmIn(record);
        int index = record.partition();
        System.out.println("[myGroup1] <c1>: alarmIn: " + alarmIn + ", partition: " + index);
    }

    @KafkaListener(topics = TOPIC_ALARM_IN, groupId = "myGroup1" )
    public void g1c2(ConsumerRecord<String, String> record) {
        AlarmIn alarmIn = parseAlarmIn(record);
        int index = record.partition();
        System.out.println("[myGroup1] <c2>: alarmIn: " + alarmIn + ", partition: " + index);
    }

    @KafkaListener(topics = TOPIC_ALARM_IN, groupId = "myGroup2" )
    public void g2c3(ConsumerRecord<String, String> record) {
        AlarmIn alarmIn = parseAlarmIn(record);
        int index = record.partition();
        System.out.println("[myGroup2] <c3>: alarmIn: " + alarmIn + ", partition: " + index);
    }

    /**
     * 解析进入告警信息
     * @param record
     * @return
     */
    private AlarmIn parseAlarmIn(ConsumerRecord<String, String> record) {
        String key = record.key();
        String value = record.value();

        AlarmIn alarmIn = null;
        try {
            alarmIn = new ObjectMapper().readValue(value, AlarmIn.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alarmIn;
    }
}
