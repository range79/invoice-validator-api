package com.metinkuzey.invoice.v2.service;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service  {
    void uploadFile(MultipartFile file);
}
