package com.acme.Components;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

public class MessageSender {

    private ConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;
    private Destination destination;
    private MessageProducer producer;
    private static final String DESTINATION_NAME = "AVG-QUEUE";
    private static final String BROKER_URL = "tcp://localhost:61616";


    public MessageSender() throws JMSException {
        String username = "artemis";
        String password = "artemis";
        connectionFactory = new ActiveMQConnectionFactory(username, password, BROKER_URL);
        connection = connectionFactory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        destination = session.createQueue(DESTINATION_NAME);
        producer = session.createProducer(destination);
    }

    public void sendMessage(String message) throws JMSException {
        TextMessage textMessage = session.createTextMessage(message);
        producer.send(textMessage);
        System.out.println("Message sent: " + message);
    }

    public void close() throws JMSException {
        if (connection != null) {
            connection.close();
        }
    }
}
