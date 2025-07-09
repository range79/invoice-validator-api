package com.metinkuzey.invoice.exception;

import com.metinkuzey.invoice.model.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(AbstractExceptionHandler.class)

public ResponseEntity<ErrorMessage> handleException(AbstractExceptionHandler ex) {
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
