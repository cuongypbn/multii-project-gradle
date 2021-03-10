package com.example.core.kafka;

import com.example.core.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

@Configuration
@Slf4j
public class Receiver {
    public CountDownLatch latch = new CountDownLatch(3);

    @KafkaListener(topics = "user",groupId = "0")
    public void receive(String message) {
        log.warn("topic user {}", message);
        latch.countDown();
    }
}
