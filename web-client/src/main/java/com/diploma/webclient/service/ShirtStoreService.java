package com.diploma.webclient.service;


import com.diploma.webclient.acpect.LogLeadTime;
import com.diploma.webclient.client.PaymentClientApi;
import com.diploma.webclient.client.StorageClientApi;
import com.diploma.webclient.model.Order;
import com.diploma.webclient.model.ShirtStoreMnf;
import com.diploma.webclient.model.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

/**
 * Сервис для осуществления покупки.
 */
@Service
public class ShirtStoreService {
    /**
     * Объект клиента Feigen для запросов к api оплаты.
     */
    private final PaymentClientApi paymentApi;

    /**
     * Объект клиента Feigen для запросов к api склада.
     */
    private final StorageClientApi storageApi;

    /**
     * Номер счета магазина.
     */
    private final String shopAccount;

    /**
     * Конструктор
     */
    public ShirtStoreService(PaymentClientApi paymentApi,
                       StorageClientApi storageApi,
                       @Value("${shop.account.number}") String shopAccount) {
        this.paymentApi = paymentApi;
        this.storageApi = storageApi;
        this.shopAccount = shopAccount;
    }

    /**
     * Получение всех заказов.
     * @return список заказов.
     */
    @LogLeadTime
    public List<ShirtStoreMnf> getAll(){
        return storageApi.getProducts();
    }

    /**
     * Оформление покупки, уменьшение остатка ткани на складе.
     * @param id идентификатор продукта.
     * @param amount количество товара.
     */
    @LogLeadTime
    private void productBuy(Long id, int amount)
            throws HttpClientErrorException {
        storageApi.buy(id, new Order(amount));
    }

    /**
     * Оплата товара
     * @param sum сумма для оплаты
     * @param numberCredit номер счета списания
     */
    @LogLeadTime
    public ResponseEntity<?> payOrder(Double sum, Long numberCredit)
            throws HttpClientErrorException {
        return paymentApi.pay(
                new Transaction(numberCredit, Long.parseLong(shopAccount), sum));
    }


}
