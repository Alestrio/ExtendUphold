package com.alestrio.extenduphold.data.api.assets;

public enum Equities {
    SP500("SPY"),
    APPLE("AAPL"),
    AMAZON("AMZN"),
    POWERSHARES("QQQ"),
    MICROSOFT("MSFT"),
    ALIBABA("BABA"),
    FACEBOOK("FB"),
    ROKU("ROKU"),
    TESLA("TSLA"),
    ISHARES2000("IWM"),
    NETFLIX("NFLX"),
    ISHARESMSCI("EEM"),
    VANECKVECTORS("GDX"),
    ALPHABETCA("GOOGL"),
    AMD("AMD"),
    ALPHABETCC("GOOG"),
    NVIDIA("NVDA"),
    BOEING("BA"),
    BANKOFAMERICA("BAC"),
    VISA("V"),
    ISHAREMSCIEAFE("EFA"),
    ISHARES20PLUS("TLT"),
    ISHARESIBOXX("HYG"),
    JPMORGAN("JPM"),
    DANAHER("DHR"),
    DISNEY("DIS"),
    FINANCIALSELECT("XLF"),
    ISHARESIBOXXDOLLAR("LQD"),
    ATT("T"),
    INTEL("INTC"),
    SPDRGOLD("GLD"),
    UNITEDHEALTH("UNH"),
    JOHNSONANDJOHNSON("JNJ"),
    ISHARESCORESP("IVV"),
    PROSHARESULTRAPRO("TQQQ"),
    WELLSFARGO("WFC"),
    CISCO("CSCO"),
    MICRONTECHNOLOGY("MU"),
    UTILITIESSELECT("XLU"),
    HOMEDEPOT("HD"),
    CITIGROUP("C"),
    MASTERCARD("MA"),
    ISHARESMSCIBRAZEIL("EWZ"),
    BRISTOLMEYERS("BMY"),
    EXXON("XOM"),
    PROCTERGAMBLE("PG"),
    ISHARESFTSE("FXI"),
    COMCAST("CMCSA"),
    BERKSHIRE("BRK.B"),
    ADOBE("ADBE")
    ;


    private final String symbol;

    Equities(String symbol) {
        this.symbol = symbol;
    }
}
