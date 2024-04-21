package com.acme;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BrokerApplication {

    private static final String DESTINATION_NAME = "AVG-TOPIC";
    private static final String BROKER_URL = "tcp://localhost:61616";

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(BrokerApplication.class, args);
        TopicCreator.createTopic(DESTINATION_NAME, BROKER_URL);
    }
}
