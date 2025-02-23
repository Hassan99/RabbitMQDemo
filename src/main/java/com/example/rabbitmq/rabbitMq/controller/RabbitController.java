package com.example.rabbitmq.rabbitMq.controller;

import com.example.rabbitmq.rabbitMq.producer.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RabbitController {

    private RabbitMQProducer producer;

    public RabbitController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    private ResponseEntity<String> publishMessage(@RequestBody Object message) {

        producer.sendMessage(message.toString());
        return ResponseEntity.ok("Message sent to RabbitMQ: the message is:" + message);
    }
}
