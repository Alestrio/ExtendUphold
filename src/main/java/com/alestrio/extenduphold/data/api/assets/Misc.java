package com.alestrio.extenduphold.data.api.assets;

public enum Misc implements AbstractAsset{
    UNIVERSALBITCOIN("UPBTC");

    private final String symbol;

    Misc(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
