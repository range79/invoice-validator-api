package com.metinkuzey.invoice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class S3Service {

    @Value("${aws.region}")
    private String awsRegion;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    public String uploadFile(MultipartFile file) throws IOException {

            // Create a temporary file to upload
            Path tempFile = Files.createTempFile("upload-", file.getOriginalFilename());
            file.transferTo(tempFile.toFile());

            S3Client s3Client = S3Client.builder()
                    .region(Region.of(awsRegion))
                    .credentialsProvider(DefaultCredentialsProvider.create())
                    .build();

            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(file.getOriginalFilename())
                    .build();

            s3Client.putObject(putObjectRequest, tempFile);

            Files.deleteIfExists(tempFile);
            return file.getOriginalFilename();

    }
}