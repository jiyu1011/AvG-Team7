package com.acme.Entity;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Producer implements Serializable {
    private UUID uuid;
    private String Ort;
    private String TickerSymbol;
    public List<Wertpapier> wertpapierList;

    private Random rand = new Random();

    public void ChangePrice(){
        wertpapierList.forEach(wertpapier -> wertpapier.setPreis( wertpapier.getPreis() + rand.nextDouble()));
    }

    public void RaisePrice(){
        wertpapierList.forEach(wertpapier -> wertpapier.setPreis(wertpapier.getPreis() + 2.00));
    }

    public void LowerPrice(){
        wertpapierList.forEach(wertpapier -> wertpapier.setPreis(wertpapier.getPreis() - 2.00));
    }
}
