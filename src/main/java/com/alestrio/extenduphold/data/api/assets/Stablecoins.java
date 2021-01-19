package com.alestrio.extenduphold.data.api.assets;

public enum Stablecoins implements AbstractAsset{
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

    @Override
    public String getSymbol() {
        return symbol;
    }
}
