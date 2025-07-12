package com.metinkuzey.invoice.v2.service;

import com.metinkuzey.invoice.v2.domain.model.Invoice;
import com.metinkuzey.invoice.v2.dto.InvoiceResponse;
import com.metinkuzey.invoice.v2.dto.UploadInvoice;

import java.util.List;

public interface InvoiceService {

    InvoiceResponse uploadFile(UploadInvoice uploadInvoice);
    List<Invoice> getAllInvoices() ;
    Invoice getInvoice(Long id);
    InvoiceResponse getInvoiceResponse(Long id);
    List<InvoiceResponse> getAllInvoiceResponses();

}
