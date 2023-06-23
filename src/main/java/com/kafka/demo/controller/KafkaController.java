package com.kafka.demo.controller;

import com.kafka.demo.service.producer.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zoomSpaceFlight")
public class KafkaController {
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/publish")
    public void sendMessageToKafka(@RequestParam("message") String message){
        kafkaProducerService.send(message);
    }
}
