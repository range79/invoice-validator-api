package com.metinkuzey.invoice.service;

import com.metinkuzey.invoice.model.Invoice;
import com.metinkuzey.invoice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class InvoiceService {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceService.class);

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getAllInvoices() {
        logger.info("Fetching all invoices from the database");
        return invoiceRepository.findAll();
    }

    public Invoice saveInvoice(Invoice invoice) {
        logger.info("Saving invoice with filename: {}", invoice.getFilename());
        return invoiceRepository.save(invoice);
    }
}