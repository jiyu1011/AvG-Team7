package com.acme;


import com.acme.Components.MessageSender;
import com.acme.Entity.Producer;
import com.acme.Repository.MockDB;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
import javax.jms.ConnectionFactory;

@SpringBootApplication
public class ProducerApplication {

    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String TOPIC_NAME = "AVG-TOPIC";
    private static final String QUEUE_NAME = "AVG-QUEUE";
    private static final String USERNAME = "artemis";
    private static final String PASSWORD = "artemis";

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);
        Connection connection = null;
        Session session = null;
        MessageProducer producer = null;

        try {
            connection = connectionFactory.createConnection();
            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createTopic(TOPIC_NAME);

            producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            for (Producer prod : MockDB.PRODUCERS) {
                try {
                    MessageSender messageSender = new MessageSender();
                    messageSender.sendMessage(prod.toString());
                    messageSender.close();
                } catch (Exception e) {
                    e.printStackTrace(); //TODO Logger
                }
            }


            for (int i = 0; i < 10; i++) {
                double price = Math.random() * 100;
                String stock = "Stock" + i;
                TextMessage message = session.createTextMessage(stock + ": $" + String.format("%.2f", price));
                producer.send(message);
                System.out.println("Sent: " + message.getText());
            }

        } finally {
            if (producer != null) {
                producer.close();
            }
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
