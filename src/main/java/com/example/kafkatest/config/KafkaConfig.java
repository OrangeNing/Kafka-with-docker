package com.example.kafkatest.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.internals.Topic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    public static final String TOPIC_ALARM_IN = "topic_alarm_in";

    /**
     * 声明Topic，设置其分区数为4
     */
    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name(TOPIC_ALARM_IN)
                .partitions(4)
                .build();
    }

}
