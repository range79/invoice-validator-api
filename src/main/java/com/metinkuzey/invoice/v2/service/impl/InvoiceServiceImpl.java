package com.metinkuzey.invoice.v2.service.impl;

import com.metinkuzey.invoice.global.exception.InvoiceNotFoundException;
import com.metinkuzey.invoice.v2.domain.model.Invoice;
import com.metinkuzey.invoice.v2.domain.repository.InvoiceRepository;
import com.metinkuzey.invoice.v2.dto.InvoiceResponse;
import com.metinkuzey.invoice.v2.dto.UploadInvoice;
import com.metinkuzey.invoice.v2.mapper.InvoiceMapper;
import com.metinkuzey.invoice.v2.service.InvoiceService;
import com.metinkuzey.invoice.v2.service.S3Service;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;
    private final S3Service s3Service;
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper,S3Service s3Service) {
        this.s3Service = s3Service;
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }
    @Override
    public InvoiceResponse uploadFile(UploadInvoice uploadInvoice) {
        s3Service.uploadFile(uploadInvoice.getFile());
        Invoice inv = invoiceMapper.toEntity(uploadInvoice);
        Invoice invoice =  invoiceRepository.save(inv);
        return invoiceMapper.toDto(invoice);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }


    @Override
    public Invoice getInvoice(Long id) {
        return getInvoiceFromRepo(id);
    }

    @Override
    public InvoiceResponse getInvoiceResponse(Long id) {
        Invoice invoice = getInvoiceFromRepo(id);
        return invoiceMapper.toDto(invoice);
    }

    @Override
    public List<InvoiceResponse> getAllInvoiceResponses() {
        return invoiceRepository.findAll().stream().map(invoiceMapper::toDto)
                .collect(Collectors.toList());
    }


    private  Invoice getInvoiceFromRepo(Long id){
        return invoiceRepository.findById(id)
                .orElseThrow(()->
                new InvoiceNotFoundException(String.format("invoice not found %d", id)));
    }
}




