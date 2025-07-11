package com.metinkuzey.invoice.v1.repository;

import com.metinkuzey.invoice.v1.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}