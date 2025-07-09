package com.metinkuzey.invoice.api;

import com.metinkuzey.invoice.model.Invoice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api/invoices")
public interface UploadApi {
    @PostMapping("/upload")
    ResponseEntity<String> uploadInvoice(@RequestParam("file") MultipartFile file) throws IOException;
    @GetMapping
    ResponseEntity<List<Invoice>> getAllInvoices();
}
