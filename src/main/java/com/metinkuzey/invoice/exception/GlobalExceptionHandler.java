package com.metinkuzey.invoice.exception;

import com.metinkuzey.invoice.model.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(AbstractExceptionHandler.class)
    public ResponseEntity<ErrorMessage> handleException(AbstractExceptionHandler ex) {
        log.error(ex.getMessage());
        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(new ErrorMessage(
                                ex.getMessage(),
                                ex.getClass().getName(),
                                LocalDateTime.now()
                        )
                );

    }
    @ExceptionHandler(
            value = {S3Exception.class,IOException.class}
    )
    public ResponseEntity<ErrorMessage> handleException(Exception ex) {
        log.error(ex.getMessage());
        return ResponseEntity
                .status(500)
                .body(new ErrorMessage(
                                ex.getMessage(),
                                ex.getClass().getName(),
                                LocalDateTime.now()
                        )
                );



    }





}
