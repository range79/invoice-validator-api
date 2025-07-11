package com.metinkuzey.invoice.v1.service;

import com.metinkuzey.invoice.global.exception.FileExtensionNotAllowed;
import com.metinkuzey.invoice.v1.model.Invoice;
import com.metinkuzey.invoice.v1.repository.InvoiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class InvoiceService {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceService.class);

    private final S3Service s3Service;
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(S3Service s3Service, InvoiceRepository invoiceRepository) {
        this.s3Service = s3Service;
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getAllInvoices() {
        logger.info("Fetching all invoices from the database");
        return invoiceRepository.findAll();
    }

    public void saveInvoice(MultipartFile file) throws IOException {

        if (!Objects.equals(file.getContentType(), "application/pdf")) {
            throw new  FileExtensionNotAllowed("File extension not allowed."+file.getContentType());
        }
        String uploadedFileName = s3Service.uploadFile(file);

        Invoice invoice = Invoice.builder()
                .filename(uploadedFileName)
                .status("UPLOADED")
                .vendor("UNKNOWN")
                .currency("EUR")
                .invoiceNumber("INV-" + System.currentTimeMillis())
                .totalAmount(0.0)
                .build();
        logger.info("Saving invoice to the database");
        invoiceRepository.save(invoice);
        logger.info("Invoice saved successfully");
    }
}