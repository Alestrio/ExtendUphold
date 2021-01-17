package com.alestrio.extenduphold.data.entity;

public enum SoldOrBought {
    SOLD("SOLD"),
    BOUGHT("BOUGHT");

    private final String value;

    SoldOrBought(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
