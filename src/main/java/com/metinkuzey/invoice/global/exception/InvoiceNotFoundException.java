package com.metinkuzey.invoice.global.exception;

import org.springframework.http.HttpStatus;

public class InvoiceNotFoundException extends AbstractExceptionHandler{
    public InvoiceNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
