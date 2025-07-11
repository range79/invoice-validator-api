package com.metinkuzey.invoice.v1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "invoices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filename;
   // You can store status, vendor, and currency as enums if you prefer. It's up to you.
    private String status;
    private String vendor;
    private String currency;
    private String invoiceNumber;
    private Double totalAmount;
}