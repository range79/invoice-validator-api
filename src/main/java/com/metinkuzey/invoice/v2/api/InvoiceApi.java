package com.metinkuzey.invoice.v2.api;

import com.metinkuzey.invoice.v2.domain.model.Invoice;
import com.metinkuzey.invoice.v2.dto.InvoiceResponse;
import com.metinkuzey.invoice.v2.dto.UploadInvoice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api/v2/")
public interface InvoiceApi {
    @PostMapping("/upload")
    ResponseEntity<InvoiceResponse> uploadInvoice(@ModelAttribute UploadInvoice invoice) throws IOException;
    @GetMapping("/get-all")
    ResponseEntity<List<Invoice>> getAllInvoices();
    @GetMapping("/get-all/less")
    ResponseEntity<List<InvoiceResponse>>  getAllInvoiceResponses();
    @GetMapping("/get/{id}")
    ResponseEntity<Invoice> getInvoice(@PathVariable Long id);
    @GetMapping("/get/{id}/less")
    ResponseEntity<InvoiceResponse> getInvoiceResponse(@PathVariable Long id);

}
