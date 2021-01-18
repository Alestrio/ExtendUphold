package com.alestrio.extenduphold.data.api.assets;

public enum Crypto {
    BITCOIN("BTC"),
    LITECOIN("LTC"),
    ETHEREUM("ETH"),
    BITCOINCASH("BCH"),
    BASICATTENTIONTOKEN("BAT"),
    DIGITALCASH("DASH"),
    BITCOINGOLD("BTG"),
    XRP("XRP"),
    CRED("LBA"),
    CHAINLINK("LINK"),
    ZEROX("ZRX"),
    UNIVERSALPROTOCOLTOKEN("UPT"),
    OMISEGO("OMG"),
    STORM("STORM"),
    ORCHID("OXT"),
    VCOIN("VCO"),
    COMPOUND("COMP"),
    BALANCER("BAL"),
    TRON("TRX"),
    NANO("NANO"),
    STELLAR("XLM"),
    CARDANO("ADA"),
    IOTA("IOTA"),
    COSMOS("ATOM"),
    NEO("NEO"),
    EOS("EOS"),
    NEM("XEM"),
    ZILIQA("ZIL"),
    DECRED("DCR"),
    DIGIBYTE("DGB"),
    DOGECOIN("DOGE"),
    FILECOIN("FIL"),
    POLKADOT("DOT"),
    SOLANA("SOL")
    ;

    private final String symbol;

    Crypto(String symbol) {
        this.symbol = symbol;
    }
}
