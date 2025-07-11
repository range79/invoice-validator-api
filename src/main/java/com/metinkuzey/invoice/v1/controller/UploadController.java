package com.metinkuzey.invoice.v1.controller;

import com.metinkuzey.invoice.v1.api.UploadApi;
import com.metinkuzey.invoice.v1.model.Invoice;
import com.metinkuzey.invoice.v1.service.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController

public class UploadController implements UploadApi {

    private final InvoiceService invoiceService;

    public UploadController(InvoiceService invoiceService) {

        this.invoiceService = invoiceService;
    }
    //Seriously, why is everything in the controller?
    // Also, having two services seems redundant
    // you can achieve the same with just one.

    public ResponseEntity<String> uploadInvoice(@RequestParam("file") MultipartFile file) throws IOException {
        invoiceService.saveInvoice(file);
        return ResponseEntity.ok("File uploaded and invoice saved.");

    }

    public ResponseEntity<List<Invoice>> getAllInvoices() {
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }
}