package com.example.core.kafka;

import com.example.core.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class SendUser {

    @Autowired
    private SenderUserConfig senderUserConfig;

    @Autowired
    private KafkaTemplate<String, User> simpleKafkaTemplate;

    public void send(String topicName, User user) {
        simpleKafkaTemplate.send(topicName, user);
    }
}
