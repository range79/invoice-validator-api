package com.metinkuzey.invoice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "invoices")
@Data
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;
    private String status;
    private String vendor;
    private String currency;
    private String invoiceNumber;
    private Double totalAmount;
}