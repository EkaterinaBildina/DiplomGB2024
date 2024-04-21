package com.diploma.webclient.controller;

import com.diploma.webclient.model.ShirtStoreMnf;
import com.diploma.webclient.service.ShirtStoreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.security.Principal;

@Controller
@AllArgsConstructor
public class ShirtStoreController {
    /**
     * Сервис Ателье ShirtStore
     */
    private final ShirtStoreService shirtStoreService;

    /**
     * Покупка продукта
     * @param id идентификатор заказа
     * @return Успех!
     */
    @PostMapping("/buy/{id}")
    public String buyProduct(Principal principal,
                             @PathVariable("id") int id,
                             RedirectAttributes redirectAttributes){
        ShirtStoreMnf product = shirtStoreService.getAll()
                .stream()
                .filter(prod -> prod.getId()==id)
                .findFirst()
                .orElse(null);
        Double sum = product.getAmount();
        shirtStoreService.payOrder(sum, 1L);
        return redirectAttributes.addAttribute("confirm", "Покупка успешно совершена!").toString();
    }



}
