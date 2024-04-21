package com.acme.Components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
/**
 * Controller Klasse für die Listener der Queue
 */
public class Controller {

    private static final String DESTINATION_NAME = "AVG-QUEUE";

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @JmsListener(destination = DESTINATION_NAME)
    public void messageListener(String message) {
        LOGGER.info("Message received! {}", message);
    }


}

