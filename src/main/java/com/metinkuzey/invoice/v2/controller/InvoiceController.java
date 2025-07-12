package com.metinkuzey.invoice.v2.controller;

import com.metinkuzey.invoice.v2.api.InvoiceApi;
import com.metinkuzey.invoice.v2.domain.model.Invoice;
import com.metinkuzey.invoice.v2.dto.InvoiceResponse;
import com.metinkuzey.invoice.v2.dto.UploadInvoice;
import com.metinkuzey.invoice.v2.service.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class InvoiceController implements InvoiceApi {
    private final InvoiceService invoiceService;
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public ResponseEntity<InvoiceResponse> uploadInvoice(UploadInvoice invoice) {
        return ResponseEntity.ok(invoiceService.uploadFile(invoice));
    }


    @Override
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @Override
    public ResponseEntity<List<InvoiceResponse>> getAllInvoiceResponses() {
        return ResponseEntity.ok(invoiceService.getAllInvoiceResponses());
    }

    @Override
    public ResponseEntity<Invoice> getInvoice(Long id) {
        return ResponseEntity.ok(invoiceService.getInvoice(id));
    }

    @Override
    public ResponseEntity<InvoiceResponse> getInvoiceResponse(Long id) {
        return ResponseEntity.ok(invoiceService.getInvoiceResponse(id));
    }
}
