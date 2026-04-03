# Profile Microservice HMS

[![Java](https://img.shields.io/badge/Java-21-orange)](https://openjdk.org/projects/jdk/21/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-brightgreen)](https://spring.io/projects/spring-boot)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2025.0.0-blue)](https://spring.io/projects/spring-cloud)
[![MySQL](https://img.shields.io/badge/MySQL-8-blue)](https://www.mysql.com/)
[![Docker](https://img.shields.io/badge/Docker-Ready-blue)](https://www.docker.com/)
[![Eureka](https://img.shields.io/badge/Netflix%20Eureka-Client-lightgrey)](https://cloud.spring.io/spring-cloud-netflix/)

## 🚀 What the Project Does

profile-microservice-hms is a Spring Boot microservice for managing doctor and patient profiles in a Hospital Management System (HMS). It provides REST APIs to create, read, update, and validate profiles and exposes dropdowns for client-side selection in distributed workflows. It is designed to be used as a standalone profile domain service and integrated with appointment, billing, and other HMS microservices using Spring Cloud Eureka service discovery. It supports database-backed persistence, security, CORS, and can run in Docker containers for scalable deployments.

## 💡 Why the Project is Useful

- Separates profile domain responsibilities (doctors, patients) from other HMS concerns.
- Enables centralized profile validation (exists, getProfilePictureId) for consistent cross-service behavior.
- Provides dropdown and batch lookup endpoints for UI dropdowns or bulk queries.
- Lightweight, fault-resilient API that pairs into microservice ecosystems with Eureka.

## ✨ Key Features

- Implemented doctor CRUD API: add, get by ID, update, exists, get all, dropdown list, get-by-IDs.
- Implemented patient CRUD API: add, get by ID, update, exists, get all, dropdown list, get-by-IDs.
- Designed to return profile picture ID separately for efficient image loading.
- Built with validation, consistent HTTP status codes, and exception handling via a shared HmsException model.
- Configured CORS and Eureka client support for distributed deployment.

## 🛠️ Tech Stack

- Frontend: Not included (API-only microservice)
- Backend:
  - Java 21
  - Spring Boot 3.5.3
  - Spring Web
  - Spring Data JPA
  - Spring Security
  - Spring Validation
  - Spring Cloud Netflix Eureka Client
- Database:
  - MySQL (via mysql-connector-j)
- DevOps / Tools:
  - Maven
  - Docker (Dockerfile present)
  - Spring Boot Maven Plugin

## ⚙️ Getting Started (Installation & Setup)

`ash
git clone <REPO_URL>
cd profile-microservice-hms
`

### 1. Configure Database

Set environment variables or edit src/main/resources/application.properties:

- DB_URL (default jdbc:mysql://localhost:3306/profiledb)
- DB_USERNAME (default oot)
- DB_PASSWORD (default @Vaibhav777)

### 2. Configure Eureka

- EUREKA_SERVER_URL default: http://localhost:8761/eureka/

### 3. Run Locally

`ash
./mvnw clean package
./mvnw spring-boot:run
`

Default service port: 9100 (override with PORT env var).

## 🧩 API Endpoints

### Doctor APIs (Base /profile/doctor)
- POST /profile/doctor/add
- GET /profile/doctor/get/{id}
- GET /profile/doctor/getProfilePictureId/{id}
- PUT /profile/doctor/update
- GET /profile/doctor/exists/{id}
- GET /profile/doctor/dropdowns
- GET /profile/doctor/getDoctorsById?ids=1,2,3
- GET /profile/doctor/getAll

### Patient APIs (Base /profile/patient)
- POST /profile/patient/add
- GET /profile/patient/get/{id}
- GET /profile/patient/getProfilePictureId/{id}
- PUT /profile/patient/update
- GET /profile/patient/exists/{id}
- GET /profile/patient/getPatientsById?ids=1,2,3
- GET /profile/patient/getAll

## 🧪 Tests

`ash
./mvnw test
`

## 🚢 Docker (Optional)

Build image:

`ash
docker build -t profile-microservice-hms:latest .
`

Run container:

`ash
docker run -e DB_URL=jdbc:mysql://host.docker.internal:3306/profiledb \
  -e DB_USERNAME=root -e DB_PASSWORD=yourpass \
  -e EUREKA_SERVER_URL=http://host.docker.internal:8761/eureka/ \
  -e PORT=9100 \
  -p 9100:9100 profile-microservice-hms:latest
`

## 📦 Project Metadata

- Name: profile-microservice-hms
- Description: Profile Microservice for Hospital Management System
- Artifact: com.hms:profile-microservice-hms:0.0.1-SNAPSHOT

## 🤝 Contributing

1. Fork the repo
2. Create a feature branch
3. Add tests and run ./mvnw test
4. Open PR with description and linked issue

## 📝 License

Add your open source / corporate license file at /LICENSE (e.g., Apache-2.0, MIT, etc.)
