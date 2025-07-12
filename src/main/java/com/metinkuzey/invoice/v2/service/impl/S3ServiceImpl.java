package com.metinkuzey.invoice.v2.service.impl;

import com.metinkuzey.invoice.v2.service.S3Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;
import java.io.InputStream;

@Service
public class S3ServiceImpl implements S3Service {

    @Value("${aws.s3.bucket}")
    private String bucketName;
    private final S3Client s3Client;
    public S3ServiceImpl(S3Client s3Client) {
        this.s3Client = s3Client;
    }
    @Override
    public void uploadFile(MultipartFile file) {
        try (InputStream is = file.getInputStream()) {
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(file.getOriginalFilename())
                    .build();

            s3Client.putObject(
                    putObjectRequest,
                    RequestBody.fromInputStream(is, file.getSize())
            );

            file.getOriginalFilename();
        } catch (IOException | S3Exception e) {
            throw new RuntimeException("File upload error " + e.getMessage(), e);
        }
    }
}

