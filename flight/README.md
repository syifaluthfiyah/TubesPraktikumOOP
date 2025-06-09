# Flight Booking Service API

A Spring Boot-based RESTful API service for managing flight bookings and reservations.

## Technology Stack

- Java 17
- Spring Boot 3.2.2
- Spring Security
- Spring Data JPA
- Spring WebFlux
- Thymeleaf (Template Engine)
- H2 Database
- JWT Authentication
- Maven
- Docker

## Features

- User Authentication and Authorization
- JWT-based Security
- Flight Management
- Booking System
- RESTful API Endpoints
- Database Integration
- Validation Support

## Prerequisites

- Java 17 or higher
- Maven 3.x
- Docker (optional)

## Getting Started

### Building the Project

```bash
./mvnw clean install
```

### Running the Application

#### Using Maven

```bash
./mvnw spring-boot:run
```

#### Using Docker

Build the Docker image:
```bash
docker build -t flight-booking-service .
```

Run the container:
```bash
docker run -p 8080:8080 flight-booking-service
```

## Project Structure

The project follows a standard Spring Boot application structure:

```
src/
├── main/
│   ├── java/
│   │   └── com/flight/booking/service/
│   │       ├── config/        # Configuration classes
│   │       ├── controller/    # REST controllers
│   │       ├── model/        # Domain models
│   │       ├── repository/   # Data repositories
│   │       ├── service/      # Business logic
│   │       └── security/     # Security configurations
│   └── resources/
│       └── application.properties  # Application configuration
└── test/
    └── java/                 # Test classes
```

## Security

The application uses Spring Security with JWT (JSON Web Tokens) for authentication and authorization. Protected endpoints require a valid JWT token in the Authorization header.

## Dependencies

Major dependencies include:
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Security
- Spring Boot Starter Validation
- Lombok
- H2 Database
- JWT Libraries
- Thymeleaf

## License

This project is licensed under the MIT License - see the LICENSE file for details. 