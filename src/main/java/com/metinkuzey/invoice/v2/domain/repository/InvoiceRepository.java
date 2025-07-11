package com.metinkuzey.invoice.v2.domain.repository;

import com.metinkuzey.invoice.v2.domain.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
