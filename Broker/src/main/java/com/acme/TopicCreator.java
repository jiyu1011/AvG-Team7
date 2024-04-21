package com.acme;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TopicCreator {

    public static void createTopic(String topicName, String brokerUrl) throws JMSException {
        String username = "artemis";
        String password = "artemis";
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(username, password, brokerUrl);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Topic topic = session.createTopic(topicName);

            System.out.println("Topic '" + topicName + "' wurde erfolgreich erstellt."); //TODO toLog

            session.close();
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
