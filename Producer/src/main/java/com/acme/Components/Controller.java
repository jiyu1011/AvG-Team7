package com.acme.Components;

import com.acme.Entity.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.jms.JMSException;

@RestController
public class Controller {

    private static final String DESTINATION_NAME = "AVG-QUEUE";
    private static final String BROKER_URL = "tcp://localhost:61616";

    @Autowired
    private JmsTemplate jmsTemplate;


    @PostMapping("/publishMessage")
    public ResponseEntity<String> publishMessage(@RequestBody Producer producer) {
        try {
            jmsTemplate.convertAndSend(DESTINATION_NAME, producer);
            return new ResponseEntity<>("Sent.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/publishTextMessage")
    public ResponseEntity<String> publishTextMessage(@RequestBody String message) {
        try {
            MessageSender messageSender = new MessageSender();
            messageSender.sendMessage(message);
            messageSender.close();
            return new ResponseEntity<>("Sent.", HttpStatus.OK);
        } catch (JMSException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
