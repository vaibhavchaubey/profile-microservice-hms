# Profile Microservice for Hospital Management System

[![Build](https://img.shields.io/badge/build-unknown-lightgrey.svg)](https://github.com/your-org/your-repo/actions)  
[![Maven Central](https://img.shields.io/badge/maven-3.8+-blue.svg)](https://maven.apache.org/)  
[![License](https://img.shields.io/badge/license-UNLICENSED-lightgrey.svg)](LICENSE)

## What the project does

`profile-microservice-hms` is a Spring Boot-based microservice that manages doctor and patient profile data for a Hospital Management System (HMS). It provides a REST API for CRUD operations, cross-origin support, validation, data persistence via JPA/MySQL, and discovery via Eureka.

## Why this project is useful

- Centralized profile management for doctors and patients
- Fully RESTful endpoints for the profile domain
- Built-in data validation and exception handling (`HmsException`)
- Integrates with Spring Cloud Eureka for service discovery
- Easy to extend through `DoctorService` / `PatientService` interfaces

## Key features

- Doctor endpoints:
  - `POST /profile/doctor/add`
  - `GET /profile/doctor/get/{id}`
  - `GET /profile/doctor/getProfilePictureId/{id}`
  - `PUT /profile/doctor/update`
  - `GET /profile/doctor/exists/{id}`
  - `GET /profile/doctor/dropdowns`
  - `GET /profile/doctor/getDoctorsById?ids=...`
  - `GET /profile/doctor/getAll`

- Patient endpoints:
  - `POST /profile/patient/add`
  - `GET /profile/patient/get/{id}`
  - `GET /profile/patient/getProfilePictureId/{id}`
  - `PUT /profile/patient/update`
  - `GET /profile/patient/exists/{id}`
  - `GET /profile/patient/getPatientsById?ids=...`
  - `GET /profile/patient/getAll`

- Configurable via `application.properties` and environment variables:
  - `server.port` (default `9100`)
  - `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`
  - `EUREKA_SERVER_URL`
  - `CORS_ALLOWED_ORIGINS`

## Tech stack

- Java 21
- Spring Boot 3.5.3
- Spring Data JPA
- Spring Security
- Spring Validation
- Spring Cloud Netflix Eureka (client)
- MySQL
- Lombok
- Maven

## How users can get started

### Prerequisites

- Java 21
- Maven 3.8+
- MySQL server
- Eureka server (for discovery)

### Clone repository

```bash
git clone <repo-url>
cd profile-microservice-hms
```

### Configure environment

Create a `.env` or set environment variables as needed:

- `PORT` (optional, default 9100)
- `DB_URL` (default `jdbc:mysql://localhost:3306/profiledb`)
- `DB_USERNAME` (default `root`)
- `DB_PASSWORD` (secure value)
- `EUREKA_SERVER_URL` (default `http://localhost:8761/eureka/`)
- `CORS_ALLOWED_ORIGINS` (default `http://localhost:5173`)

Check `src/main/resources/application.properties` for the canonical defaults.

### Run

```bash
./mvnw clean package
./mvnw spring-boot:run
```

or

```bash
mvn clean package
mvn spring-boot:run
```

### Verify

- `http://localhost:9100/profile/doctor/getAll`
- `http://localhost:9100/profile/patient/getAll`

## Example requests

### Add doctor

```bash
curl -X POST http://localhost:9100/profile/doctor/add \
  -H "Content-Type: application/json" \
  -d '{"id":null,"name":"Dr. John","specialization":"Cardiology","profilePictureId":1}'
```

### Get patient

```bash
curl http://localhost:9100/profile/patient/get/1
```

## Where users can get help

- Open an issue in this repository
- Check existing project docs and API specs in the repo
- Contact maintainers via the project README or issue tracker

## Who maintains and contributes

Maintained by the project team in this repository.  
Please follow standard GitHub collaboration:

- Fork the repository
- Create a feature branch
- Open a pull request

> Note: no `CONTRIBUTING.md` exists in this repository; add one in `docs/CONTRIBUTING.md` if you want curated contribution guidelines.

## Project structure

- `src/main/java/com/hms/profile/api`: REST controllers
- `src/main/java/com/hms/profile/dto`: data transfer objects
- `src/main/java/com/hms/profile/entity`: JPA entities
- `src/main/java/com/hms/profile/service`: service layer and implementations
- `src/main/java/com/hms/profile/repository`: Spring Data repositories
- `src/main/java/com/hms/profile/config`: CORS/security configuration
- `src/main/java/com/hms/profile/utility`: exception handler and error models

## Testing

```bash
./mvnw test
```

## Release & versioning

Uses Maven `0.0.1-SNAPSHOT`. Update `pom.xml` version for releases.

## License

See `LICENSE` in repository root.
