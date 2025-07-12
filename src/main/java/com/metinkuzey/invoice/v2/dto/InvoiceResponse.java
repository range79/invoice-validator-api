package com.metinkuzey.invoice.v2.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponse {
    private Long id;
    private String filename;
    private UUID invoiceNumber;
}
