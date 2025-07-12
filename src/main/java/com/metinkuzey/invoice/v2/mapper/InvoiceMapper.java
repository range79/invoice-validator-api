package com.metinkuzey.invoice.v2.mapper;

import com.metinkuzey.invoice.v2.domain.model.Invoice;
import com.metinkuzey.invoice.v2.dto.InvoiceResponse;
import com.metinkuzey.invoice.v2.dto.UploadInvoice;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InvoiceMapper {


public Invoice toEntity(UploadInvoice uploadInvoice) {
    UUID uuid = UUID.randomUUID();
    return Invoice.builder()
            .filename(uploadInvoice.getFile().getOriginalFilename())
            .vendor(uploadInvoice.getVendor())
            .status(uploadInvoice.getStatus())
            .currency(uploadInvoice.getCurrency())
            .invoiceNumber(uuid)
            .totalAmount(uploadInvoice.getTotalAmount()).build();
}
public InvoiceResponse toDto(Invoice invoice) {
    return InvoiceResponse.builder()
            .id(invoice.getId())
            .filename(invoice.getFilename())
            .invoiceNumber(invoice.getInvoiceNumber()).build();
}






}
