package com.diploma.dbtextile.exceptions;

/**
 * Недостаточно длины (количества) ткани в рулоне  для заказа
 */
public class ShortageLengthException extends RuntimeException {
    public ShortageLengthException (String message){
        super(message);
    }
}
