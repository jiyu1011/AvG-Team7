package com.acme.Repository;
import com.acme.Entity.Consumer;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Mock DB zur Simulation mehrerer Producer mit Wertpapieren
 */
public class MockDB {
    public static final List<Consumer> CONSUMERS;

    static {
        CONSUMERS = Stream.of(
                Consumer.builder()
                    .uuid(UUID.randomUUID())
                    .Name("Name000")
                    .SubscribedToTopic("AVG-TOPIC")
                    .build(),
                Consumer.builder()
                    .uuid(UUID.randomUUID())
                    .Name("Name001")
                    .SubscribedToTopic("AVG-TOPIC")
                    .build(),
                Consumer.builder()
                    .uuid(UUID.randomUUID())
                    .Name("Name002")
                    .SubscribedToTopic("AVG-TOPIC")
                    .build(),
                Consumer.builder()
                    .uuid(UUID.randomUUID())
                    .Name("Name003")
                    .SubscribedToTopic("AVG-TOPIC")
                    .build(),
                Consumer.builder()
                    .uuid(UUID.randomUUID())
                    .Name("Name004")
                    .SubscribedToTopic("AVG-TOPIC")
                    .build(),
                Consumer.builder()
                    .uuid(UUID.randomUUID())
                    .Name("Name005")
                    .SubscribedToTopic("AVG-TOPIC")
                    .build(),
                Consumer.builder()
                    .uuid(UUID.randomUUID())
                    .Name("Name006")
                    .SubscribedToTopic("AVG-TOPIC")
                    .build(),
                Consumer.builder()
                    .uuid(UUID.randomUUID())
                    .Name("Name007")
                    .SubscribedToTopic("AVG-TOPIC")
                    .build(),
                Consumer.builder()
                    .uuid(UUID.randomUUID())
                    .Name("Name008")
                    .SubscribedToTopic("AVG-TOPIC")
                    .build(),
                Consumer.builder()
                    .uuid(UUID.randomUUID())
                    .Name("Name009")
                    .SubscribedToTopic("AVG-TOPIC")
                    .build(),
                Consumer.builder()
                    .uuid(UUID.randomUUID())
                    .Name("Name010")
                    .SubscribedToTopic("AVG-TOPIC")
                    .build()
        )
        .collect(Collectors.toList());
    }

    private MockDB() {
    }
}
