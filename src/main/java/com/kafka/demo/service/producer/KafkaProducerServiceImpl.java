package com.kafka.demo.service.producer;

import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${demo.kafka.topic}")
    private String topic;

    @Value("${demo.kafka.loopCount}")
    private Integer loopCount;

    public KafkaProducerServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String message) {
        log.info("loopCount : {}; topic : {}", loopCount, topic);
        log.info("message sent : {}", message);
        for (int i = 0; i < loopCount; i++) {
            message = message + "-" + i + "-" + UUID.randomUUID();
            kafkaTemplate.send(topic, message);
        }
    }

}
