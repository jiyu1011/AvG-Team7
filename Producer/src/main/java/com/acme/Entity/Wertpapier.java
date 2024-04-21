package com.acme.Entity;

import java.util.Currency;
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
public class Wertpapier {
    private UUID uuid;
    private String Emittent;
    private String TickerSymbol;
    private Double Preis;
    private Currency Waehrung;
}
