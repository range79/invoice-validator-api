package com.metinkuzey.invoice.controller;

import com.metinkuzey.invoice.service.S3Service;
import com.metinkuzey.invoice.model.Invoice;
import com.metinkuzey.invoice.service.InvoiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/invoices")
public class UploadController {

    private final S3Service s3Service;
    private final InvoiceService invoiceService;

    @Autowired
    public UploadController(S3Service s3Service, InvoiceService invoiceService) {
        this.s3Service = s3Service;
        this.invoiceService = invoiceService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadInvoice(@RequestParam("file") MultipartFile file) {
        try {
            // Dosya tipi kontrolü
            if (!file.getContentType().equals("application/pdf")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Only PDF files are allowed.");
            }
            String uploadedFileName = s3Service.uploadFile(file);

            Invoice invoice = new Invoice();
            invoice.setFilename(uploadedFileName);
            invoice.setStatus("UPLOADED");
            invoice.setVendor("UNKNOWN");
            invoice.setCurrency("EUR");
            invoice.setInvoiceNumber("INV-" + System.currentTimeMillis());
            invoice.setTotalAmount(0.0);

            invoiceService.saveInvoice(invoice);

            return ResponseEntity.ok("File uploaded and invoice saved.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Upload failed: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        return ResponseEntity.ok(invoices);
    }
}