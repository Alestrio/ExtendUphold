package com.alestrio.extenduphold.data.entity;

import com.alestrio.extenduphold.data.AbstractEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Transaction extends AbstractEntity {
    @NotNull
    @NotEmpty
    private String pair;

    @NotNull
    @NotEmpty
    private String amount;

    @NotNull
    @NotEmpty
    private SoldOrBought sold_or_bought;

    public Transaction(@NotNull @NotEmpty String pair, double amount, SoldOrBought sold_or_bought) {
        this.pair = pair;
        this.amount = Double.toString(amount);
        this.sold_or_bought = sold_or_bought;
    }

    public Transaction() {}

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public double getAmount() {
        return Double.parseDouble(amount);
    }

    public void setAmount(double amount) {
        this.amount = Double.toString(amount);
    }

    public SoldOrBought getSold_or_bought() {
        return sold_or_bought;
    }

    public void setSold_or_bought(SoldOrBought sold_or_bought) {
        this.sold_or_bought = sold_or_bought;
    }
}

