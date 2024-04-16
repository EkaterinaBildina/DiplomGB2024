package com.diploma.webclient.model;

import com.diploma.dbtextile.model.Textile;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ShirtConstructor {
    private int id; // идентификатор заказа
    private String pattern; // выкройка
    private Textile textile; // ткань
    private double amount; //  количество

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public Textile getTextile() {
        return textile;
    }

    public void setTextile(Textile textile) {
        this.textile = textile;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
