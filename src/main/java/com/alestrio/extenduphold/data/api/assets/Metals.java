package com.alestrio.extenduphold.data.api.assets;

public enum Metals {
    GOLD("XAU"),
    PALLADIUM("XPD"),
    PLATINUM("XPT"),
    SILVER("XAG"),
    UNIVERSALGOLD("UPXAU");

    private final String symbol;

    Metals(String symbol) {
        this.symbol = symbol;
    }
}
