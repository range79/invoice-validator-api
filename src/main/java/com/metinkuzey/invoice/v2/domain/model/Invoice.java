package com.metinkuzey.invoice.v2.domain.model;

import com.metinkuzey.invoice.v2.domain.enums.Currency;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "invoices-v2")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filename;
    private String vendor;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private String status;
    private Currency currency;
    private UUID invoiceNumber;
    private Double totalAmount;
}
