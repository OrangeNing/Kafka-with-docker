package com.example.kafkatest.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaSendResultHandler implements ProducerListener {

    @Override
    public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
        String info = "[发送成功]: ";
        String resultStr = buildResult(producerRecord);
        System.out.println( info + resultStr );
    }

    @Override
    public void onError(ProducerRecord producerRecord, RecordMetadata recordMetadata, Exception exception) {
        String info = "[发送失败]: ";
        String resultStr = buildResult(producerRecord);
        System.out.println( info + resultStr );
        exception.printStackTrace();
        System.out.println();
    }

    private String buildResult(ProducerRecord<String, String> producerRecord) {
        String topic = producerRecord.topic();
        String key = producerRecord.key();
        String value = producerRecord.value();
        String str = " <topic>: " + topic + ", <key>: " + key + ", <value> :" + value;
        return str;
    }
}
