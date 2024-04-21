package com.acme.Repository;
import com.acme.Entity.Producer;
import com.acme.Entity.Wertpapier;
import java.util.Currency;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.Locale.GERMANY;

/**
 * Mock DB zur Simulation mehrerer Producer mit Wertpapieren
 */
public class MockDB {
    public static final List<Wertpapier> WERTPAPIERS;

    public static final List<Producer> PRODUCERS;

    static {
        final var currencyGermany = Currency.getInstance(GERMANY);
        WERTPAPIERS = Stream.of(
                Wertpapier.builder()
                    .uuid(UUID.randomUUID())
                    .Emittent("Adidas")
                    .TickerSymbol("ADI")
                    .Preis(100.00)
                    .Waehrung(currencyGermany)
                    .build(),
                Wertpapier.builder()
                    .uuid(UUID.randomUUID())
                    .Emittent("Bayer")
                    .TickerSymbol("BAY")
                    .Preis(120.00)
                    .Waehrung(currencyGermany)
                    .build(),
                Wertpapier.builder()
                    .uuid(UUID.randomUUID())
                    .Emittent("HelloFresh")
                    .TickerSymbol("HEF")
                    .Preis(140.00)
                    .Waehrung(currencyGermany)
                    .build(),
                Wertpapier.builder()
                    .uuid(UUID.randomUUID())
                    .Emittent("BASF")
                    .TickerSymbol("BAS")
                    .Preis(160.00)
                    .Waehrung(currencyGermany)
                    .build(),
                Wertpapier.builder()
                    .uuid(UUID.randomUUID())
                    .Emittent("Puma")
                    .TickerSymbol("PUM")
                    .Preis(180.00)
                    .Waehrung(currencyGermany)
                    .build(),
                Wertpapier.builder()
                    .uuid(UUID.randomUUID())
                    .Emittent("SAP")
                    .TickerSymbol("SAP")
                    .Preis(200.00)
                    .Waehrung(currencyGermany)
                    .build(),
                Wertpapier.builder()
                    .uuid(UUID.randomUUID())
                    .Emittent("TeamViewer")
                    .TickerSymbol("TMV")
                    .Preis(220.00)
                    .Waehrung(currencyGermany)
                    .build(),
                Wertpapier.builder()
                    .uuid(UUID.randomUUID())
                    .Emittent("Daimler")
                    .TickerSymbol("DAI")
                    .Preis(240.00)
                    .Waehrung(currencyGermany)
                    .build(),
                Wertpapier.builder()
                    .uuid(UUID.randomUUID())
                    .Emittent("Continental")
                    .TickerSymbol("CON")
                    .Preis(260.00)
                    .Waehrung(currencyGermany)
                    .build()
        )
                .collect(Collectors.toList());
}
    static {
        PRODUCERS = Stream.of(
                        Producer.builder()
                                .uuid(UUID.randomUUID())
                                .Ort("Frankfurt")
                                .wertpapierList(WERTPAPIERS)
                                .build(),
                        Producer.builder()
                                .uuid(UUID.randomUUID())
                                .Ort("Stuttgart")
                                .wertpapierList(WERTPAPIERS)
                                .build(),
                        Producer.builder()
                                .uuid(UUID.randomUUID())
                                .Ort("Amsterdam")
                                .wertpapierList(WERTPAPIERS)
                                .build(),
                        Producer.builder()
                                .uuid(UUID.randomUUID())
                                .Ort("London")
                                .wertpapierList(WERTPAPIERS)
                                .build(),
                        Producer.builder()
                                .uuid(UUID.randomUUID())
                                .Ort("Paris")
                                .wertpapierList(WERTPAPIERS)
                                .build(),
                        Producer.builder()
                                .uuid(UUID.randomUUID())
                                .Ort("Mailand")
                                .wertpapierList(WERTPAPIERS)
                                .build(),
                        Producer.builder()
                                .uuid(UUID.randomUUID())
                                .Ort("Kopenhagen")
                                .wertpapierList(WERTPAPIERS)
                                .build(),
                        Producer.builder()
                                .uuid(UUID.randomUUID())
                                .Ort("Shanghai")
                                .wertpapierList(WERTPAPIERS)
                                .build(),
                        Producer.builder()
                                .uuid(UUID.randomUUID())
                                .Ort("Berlin")
                                .wertpapierList(WERTPAPIERS)
                                .build()
                )
                .collect(Collectors.toList());
    }
    private MockDB() {

    }
}
