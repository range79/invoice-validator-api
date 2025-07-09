package com.metinkuzey.invoice.model;

import lombok.*;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private String message;
    private String details;
    private LocalDateTime timestamp;
}
