package com.example.core;

import com.example.core.kafka.ReceiverUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class WebApplication {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(WebApplication.class, args);
        ReceiverUser receiverUser = context.getBean(ReceiverUser.class);
        receiverUser.latchDelay.wait(10, 10);
    }
}
