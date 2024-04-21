package com.diploma.paymentapp.controller;

import com.diploma.paymentapp.exception.ExceptionBody;
import com.diploma.paymentapp.exception.ExcessAmountException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AdviceController {

    /**
     * Исключение при превышении лимита средств на счету.
     *
     * @param e объект исключения.
     * @return обертку с собственным исключением.
     */
    @ExceptionHandler(ExcessAmountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody excessAmount(ExcessAmountException e) {
        ExceptionBody exceptionBody = new ExceptionBody();
        exceptionBody.setMessage(e.getMessage());
        exceptionBody.setDateTime(LocalDateTime.now());
        return exceptionBody;
    }

}
