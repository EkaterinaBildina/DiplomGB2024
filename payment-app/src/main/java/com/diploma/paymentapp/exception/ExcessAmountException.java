package com.diploma.paymentapp.exception;

/**
 * Недостаточно средств на счету
 */
public class ExcessAmountException extends RuntimeException {
    public ExcessAmountException(String message) {
        super(message);
    }
}
