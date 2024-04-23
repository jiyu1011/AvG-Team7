package com.acme.config;

import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import javax.jms.ConnectionFactory;


@Configuration
@EnableJms
/**
 * Konfigurationsklasse für JMS und ActiveMQ
 */
public class JMSConfig {

    @Bean
    /**
     * Instanzierung der JMS Listener Container Factory
     */
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(
            ConnectionFactory connectionFactory) {

        DefaultJmsListenerContainerFactory factory
                = new DefaultJmsListenerContainerFactory();

        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrency("100-1000"); /* */

        return factory;
    }

    public PooledConnectionFactory jmsPooledListenerContainerFactory(
            ConnectionFactory connectionFactory) {
        PooledConnectionFactory factory
                = new PooledConnectionFactory();

        factory.setConnectionFactory(connectionFactory);
        factory.setConnectionTimeout(5000);
        return factory;
    }
}



