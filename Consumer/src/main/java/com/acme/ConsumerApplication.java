package com.acme;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
import javax.jms.ConnectionFactory;

@SpringBootApplication
public class ConsumerApplication {

    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String TOPIC_NAME = "AVG-TOPIC";
    private static final String QUEUE_NAME = "AVG-QUEUE";
    private static final String USERNAME = "artemis";
    private static final String PASSWORD = "artemis";

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);

                ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);
                Connection connection = null;
                Session session = null;
                MessageConsumer consumer = null;

                try {
                    // Verbindung zum Message Broker herstellen
                    connection = connectionFactory.createConnection();
                    connection.start();

                    // Sitzung erstellen
                    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

                    // Ziel (Topic) erstellen
                    Destination destination = session.createTopic(TOPIC_NAME);

                    // Consumer für das Topic erstellen
                    consumer = session.createConsumer(destination);

                    // Nachrichten empfangen und verarbeiten
                    consumer.setMessageListener(message -> {
                        try {
                            if (message instanceof TextMessage) {
                                TextMessage textMessage = (TextMessage) message;
                                System.out.println("Received: " + textMessage.getText());
                            }
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    });

                    // Warten, damit der Consumer Nachrichten empfangen kann
                    Thread.sleep(5000); // 5 Sekunden warten, bevor das Programm beendet wird

                } catch (JMSException | InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // Ressourcen schließen
                    try {
                        if (consumer != null) {
                            consumer.close();
                        }
                        if (session != null) {
                            session.close();
                        }
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

