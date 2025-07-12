package com.metinkuzey.invoice.v2.dto;

import com.metinkuzey.invoice.v2.domain.enums.Currency;
import com.metinkuzey.invoice.v2.domain.enums.InvoiceStatus;
import com.metinkuzey.invoice.v2.domain.enums.Vendor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class UploadInvoice {
    private MultipartFile file;
    private Currency currency;
    private Vendor vendor;
    private InvoiceStatus status;
    private Double totalAmount;
}
