package com.acme.Entity;

import java.util.UUID;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Consumer {
    private UUID uuid;
    private String Name;
    private String SubscribedToTopic;
}
