package com.alestrio.extenduphold.data.api.assets;

public enum Fiat implements AbstractAsset{
    USDOLLAR("USD"),
    EURO("EUR"),
    BRITISHPOUND("GBP"),
    CANADIANDOLLAR("CAD"),
    ARGENTINIANPESOS("ARS"),
    AUSTRALIANDOLLAR("AUD"),
    BRAZILIANREAL("BRL"),
    CHINESEYUAN("CNY"),
    CZECHKORUNA("CZK"),
    DANISHKRONE("DKK"),
    HONGKONGDOLLAR("HKD"),
    HUNGARIANFORINT("HUF"),
    INDIANRUPEE("INR"),
    ISRAELISHEKEL("ILS"),
    JAPANESEYEN("JPY"),
    KENYANSHILLIING("KES"),
    MEXICANPESO("MXN"),
    NEWZEALANDDOLLAR("NZD"),
    NORWEGIANKRONE("NOK"),
    PHILIPPINEPESO("PHP"),
    POLISHZLOTY("PLN"),
    ROMANIANLEU("RON"),
    SINGAPOREDOLLAR("SGD"),
    SWEDISHKRONA("SEK"),
    SWISSFRANC("CHF"),
    UAEDIRAM("AED"),
    CROATIANKUNA("HRK")
    ;

    private final String symbol;

    Fiat(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
