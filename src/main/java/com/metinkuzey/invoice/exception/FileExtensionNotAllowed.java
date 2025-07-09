package com.metinkuzey.invoice.exception;

import org.springframework.http.HttpStatus;

public class FileExtensionNotAllowed extends AbstractExceptionHandler{
    public FileExtensionNotAllowed(String message){
        super(message, HttpStatus.BAD_REQUEST);
    }
}
