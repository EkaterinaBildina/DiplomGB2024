package com.diploma.paymentapp.controller;


import com.diploma.paymentapp.model.Account;
import com.diploma.paymentapp.model.Transaction;
import com.diploma.paymentapp.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Контроллер оплаты.
 */
@RestController
@AllArgsConstructor
public class PaymentController {
    /**
     * Сервис оплаты.
     */

    private final PaymentService paymentService;

    /**
     * Получение всех аккаунтов
     * @return лист аккаунтов оплаты
     */
    @GetMapping()
    public ResponseEntity<List<Account>> getAccounts(){
        return ResponseEntity.ok().body(paymentService.getAllAccounts());
    }

    /**
     * Проведение оплаты
     *
     * @param transaction объект с данными для транзакции
     * @return ответ с подтверждением
     */
    @PostMapping()
    public ResponseEntity<String> transaction(@RequestBody Transaction transaction){
        paymentService.transaction(transaction);
        String message = "Оплата произведена успешно!";
        return ResponseEntity.ok().body(message);
    }

}
