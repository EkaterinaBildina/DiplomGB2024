package com.diploma.webclient.model;

/**
 * Объект с данными для транзакции.
 */
public record Transaction (Long creditNumber, Long debitNumber, Double sum) {
}
