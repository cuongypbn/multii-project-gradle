package com.example.core.kafka;

import com.example.core.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendUser {

    @Autowired
    private SenderUserConfig senderUserConfig;

    public void send(String topicName, User user) {
        senderUserConfig.simpleKafkaTemplate().send(topicName, user);
    }
}
