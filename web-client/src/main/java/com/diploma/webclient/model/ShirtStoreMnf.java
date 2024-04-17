package com.diploma.webclient.model;

import com.diploma.dbtextile.model.Textile;
import com.diploma.dbpatterns.model.PatternSew;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ShirtStoreMnf {
    private int id; // идентификатор заказа
    private PatternSew pattern; // выкройка
    private Textile textile; // ткань
    private double amount; //  количество

    public double getAmount() {
        return (pattern.getPrice() + pattern.getConsumption()* textile.getPrice());
    }

    public int getId() {
        return id;
    }
}
