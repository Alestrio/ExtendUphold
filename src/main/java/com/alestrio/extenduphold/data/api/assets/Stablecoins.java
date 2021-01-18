package com.alestrio.extenduphold.data.api.assets;

public enum Stablecoins {
    UPUSD("UPUSD"),
    UPEUR("UPEUR"),
    USDC("USDC"),
    TUSD("TUSD"),
    USDT("USDT"),
    DAI("DAI");

    private final String symbol;

    Stablecoins(String symbol) {
        this.symbol = symbol;
    }
}
