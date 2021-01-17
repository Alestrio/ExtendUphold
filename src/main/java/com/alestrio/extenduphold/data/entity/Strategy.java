package com.alestrio.extenduphold.data.entity;

import com.alestrio.extenduphold.data.AbstractEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Strategy extends AbstractEntity {
    @NotNull
    @NotEmpty
    private String pair;

    private String step;

    private String stoploss;

    public Strategy() { }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public double getStep() {
        return Double.parseDouble(step);
    }

    public void setStep(double step) {
        this.step = Double.toString(step);
    }

    public double getStoploss() {
        return Double.parseDouble(stoploss);
    }

    public void setStoploss(float stoploss) {
        this.stoploss = Double.toString(stoploss);
    }

    public Strategy(@NotNull @NotEmpty String pair, double stoploss) {
        this.pair = pair;
        this.stoploss = Double.toString(stoploss);
    }

    public Strategy(@NotNull @NotEmpty String pair, double step, double stoploss) {
        this.pair = pair;
        this.step = Double.toString(step);
        this.stoploss = Double.toString(stoploss);
    }
}
