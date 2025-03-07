package com.alestrio.extenduphold.data.api.assets;

public enum Environmental implements AbstractAsset {
    UNIVERSALCARBON("UPCO2"),
    BITCOINZERO("BTC0");

    private final String symbol;

    Environmental(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
