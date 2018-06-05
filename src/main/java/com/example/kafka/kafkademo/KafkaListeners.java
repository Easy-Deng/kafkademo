package com.example.kafka.kafkademo;

import org.springframework.kafka.annotation.KafkaListener;

public class KafkaListeners {


    @KafkaListener(topics = {"kafka_test"})
    public void processMessage(String content) {
        System.out.printf("接收到的数据为:"+content);
    }
}
