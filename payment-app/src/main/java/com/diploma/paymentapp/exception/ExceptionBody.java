package com.diploma.paymentapp.exception;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Обертка собственного исключения.
 */
@Data
public class ExceptionBody {
    private String message;
    private LocalDateTime dateTime;
}
