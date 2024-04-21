package com.acme.Entity;

import java.util.UUID;
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
public class Order {
    private UUID uuid;
    public Double Preis;
    private String TickerSymbol;
}
