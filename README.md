# Invoice Validator API

A Spring Boot-based RESTful web service that processes and validates invoice files. Invoices are uploaded as PDF files, stored securely in AWS S3, and metadata is stored in a PostgreSQL database on AWS RDS.

## 🌐 Features

- Upload invoices via REST endpoint
- Store PDF files in AWS S3
- Persist invoice metadata in AWS RDS (PostgreSQL)
- Validate file type (PDF only)
- Easy AWS integration with Terraform
- Structured service, controller, and repository layers

## 📦 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL (AWS RDS)
- AWS S3
- AWS Lambda (for PDF validation, optional)
- Terraform (for infrastructure provisioning)
- Maven

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven
- AWS CLI (configured)
- Terraform (optional, for provisioning resources)

### Run Locally

```bash
mvn clean install
mvn spring-boot:run
```

### API Endpoints

| Method | Endpoint                      | Description              |
|--------|-------------------------------|--------------------------|
| POST   | `/api/invoices/upload`        | Upload a PDF invoice     |
| GET    | `/api/invoices`               | Get all invoice metadata |

## ☁️ AWS Resources

Provisioned using Terraform:

- ✅ S3 Bucket for file storage
- ✅ PostgreSQL RDS for metadata
- ✅ IAM Role and Lambda function (optional)

## 📁 Project Structure

```
invoice-validator-api/
├── controller/
├── model/
├── repository/
├── service/
├── resources/
└── application.yml
```

## 📜 License

This project is licensed under the MIT License.
