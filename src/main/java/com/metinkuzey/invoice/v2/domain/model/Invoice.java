package com.metinkuzey.invoice.v2.domain.model;

import com.metinkuzey.invoice.v2.domain.enums.Currency;
import com.metinkuzey.invoice.v2.domain.enums.InvoiceStatus;
import com.metinkuzey.invoice.v2.domain.enums.Vendor;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoices-v2")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filename;
    private Vendor vendor;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;
    @Column(name = "currrency")
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private UUID invoiceNumber;
    private Double totalAmount;
}
