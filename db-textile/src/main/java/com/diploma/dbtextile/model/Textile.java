package com.diploma.dbtextile.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Textile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id; // Cotton001, Polyester001...
    private String name;
    private double price; // цена за 1м
    private double rolllength; // длина в рулоне в м

    public Textile() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRolllength() {
        return rolllength;
    }

    public void setRolllength(double rolllength) {
        this.rolllength = rolllength;
    }
}
