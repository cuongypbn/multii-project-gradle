package com.example.core.kafka;

import com.example.core.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class ReceiverUser {
    public CountDownLatch latch = new CountDownLatch(1);
    public CountDownLatch latchDelay = new CountDownLatch(1);


    @KafkaListener(topics = "user", groupId = "UserRegisteredConsumer")
    public void receive( ConsumerRecord message) {
        User user = (User) message.value();
        log.warn("topic user {}", user);
        latch.countDown();
    }

    @KafkaListener(topics = "user", groupId = "0")
    public void receiveDelay( ConsumerRecord message) {
        User user = (User) message.value();
        log.warn("topic user {}", user);
        latchDelay.countDown();
    }

//    @KafkaListener(topics = "user", groupId = "UserRegisteredConsumer")
//    public void receive(@Payload String payload) {
//        log.warn("topic user {}", payload);
//        latch.countDown();
//    }
}
