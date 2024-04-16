package com.diploma.webclient.model;

import com.diploma.dbtextile.model.Textile;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ShirtConstructor {
    private int id; // идентификатор заказа
    private String pattern; // выкройка
    private Textile textile; // ткань
    private double amount; //  количество

}
