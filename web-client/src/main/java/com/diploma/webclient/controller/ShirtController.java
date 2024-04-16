package com.diploma.webclient.controller;

import com.diploma.dbtextile.model.Textile;
import com.diploma.webclient.model.ShirtConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShirtController {
    @PostMapping("/createOder")
    public String createOrder(@RequestBody ShirtConstructor shirtConstructor){

        return  "Заказ создан успешно! " + shirtConstructor.toString();
    }

    @PostMapping("/amount")
    public double getAmount(@RequestBody ShirtConstructor shirtConstructor) {
        Pattern patternInOrder = shirtConstructor.getPattern();
        Textile textileInOrder = shirtConstructor.getTextile();
        shirtConstructor.setAmount(patternInOrder.getPrice + patternInOrder.getConsumption * textileInOrder.getPrice());
        Double orderAmount = shirtConstructor.getAmount();
        return orderAmount;
    }
}
