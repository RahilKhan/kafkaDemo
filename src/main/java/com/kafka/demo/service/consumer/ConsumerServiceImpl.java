package com.kafka.demo.service.consumer;

import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerServiceImpl implements ConsumerService {

    @Value("${demo.kafka.topic}")
    private String topic;
    @Value("${spring.kafka.consumer:group-id}")
    private String groupid;
    @Value("#{'${spring.kafka.consumer:group-id}'}")
    private String groupId;

//    @KafkaListener(groupId = "${spring.kafka.consumer:group-id}", topics = "${demo.kafka.topic}")

    @KafkaListener(groupId = "zoom-space-flight-consumer-group", topics = "${demo.kafka.topic}")
    public void receive(@Payload String message) {
        log.info("message received : {}");
        log.info("groupid : {};groupd : {}; topic : {}", groupid, groupId, topic);
    }

}
