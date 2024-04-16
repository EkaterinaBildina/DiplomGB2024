package com.diploma.paymentapp.service;


import com.diploma.paymentapp.exception.ExcessAmountException;
import com.diploma.paymentapp.model.Account;
import com.diploma.paymentapp.model.Transaction;
import com.diploma.paymentapp.repositorie.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Сервис для работы со счетами.
 */
@Service
@AllArgsConstructor
public class PaymentService {
    /**
     * Репозиторий для работы со счетами.
     */
    @Autowired
    private final PaymentRepository paymentRepository;

    /**
     * Получение всех аккаунтов.
     * @return список аккаунтов.
     */
    public List<Account> getAllAccounts() {
        return paymentRepository.findAll();
    }


    /**
     * Проведение транзакции между счетами
     * @param transaction объект с данными для транзакции.
     */
    @Transactional
    public void transaction(Transaction transaction) {
        Account creditAccount = paymentRepository.findByNumber(transaction.getCreditNumber());
        if((creditAccount.getBalance().compareTo(transaction.getSum())) < 0) {
            throw new ExcessAmountException("На Вашем счету не достаточно средств для оплаты!");
        }

        Account debitAccount = paymentRepository.findByNumber(transaction.getDebitNumber());

        creditAccount.setBalance(
                creditAccount.getBalance().subtract(transaction.getSum()));
        debitAccount.setBalance(
                debitAccount.getBalance().add(transaction.getSum()));

        paymentRepository.save(creditAccount);
        paymentRepository.save(debitAccount);
    }


}
