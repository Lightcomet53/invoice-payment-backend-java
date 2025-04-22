# Invoice Payment Backend - Java Spring Boot Project

This is a backend system for managing invoice payments, built using Java and Spring Boot. It includes features such as RESTful APIs, DTO mapping, entity persistence, service layer logic, and security configurations.

## Project Structure

```
invoice-payment-backend-java
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.dev.payment
│   │   │       ├── configuration       # Contains configuration classes such as CORS, Swagger, etc.
│   │   │       ├── controller          # REST controllers to handle API requests and responses
│   │   │       ├── dto                 # Data Transfer Objects used to encapsulate request and response data
│   │   │       ├── entity              # JPA entities representing database tables
│   │   │       ├── mapper              # Classes or interfaces to map between DTOs and entities
│   │   │       ├── repository          # Spring Data JPA repositories for database access
│   │   │       ├── security            # Security configuration like authentication, authorization, JWT, etc.
│   │   │       ├── service             # Business logic and service layer implementation
│   │   │       ├── util                # Utility/helper classes used across the project
│   │   │       └── PaymentApplication.java # Main Spring Boot application class
│   │   └── resources
│   │       ├── static                 # Static resources like CSS, JS, images (if any)
│   │       ├── templates              # Server-side templates (e.g., Thymeleaf) if used
│   │       └── application.properties # Application configuration file
│   └── test
│       └── java
│           └── com.dev.payment
│               └── PaymentApplicationTests.java # Unit and integration tests for the application
├── target                              # Compiled bytecode and packaged build output
├── pom.xml                             # Maven configuration file for dependencies and build
├── .gitignore                          # Files and folders to be ignored by Git
├── LICENSE                             # License file (e.g., MIT)
├── README.md                           # Project documentation (this file)
```

## Getting Started

### Prerequisites

- Java 24+
- Maven 3.3++
- IDE (e.g., IntelliJ IDEA)

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/invoice-payment-backend-java.git
   cd invoice-payment-backend-java
   ```

2. Build the project
   ```bash
   mvn clean install
   ```

3. Configure the Application
   - Create a `application.properties` file in `src/main/resources/`
   - Configure your database connection  and other settings:
   - ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/yourdbname
      spring.datasource.username=yourusername
      spring.datasource.password=yourpassword
     ```

4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

5. The application should now be running at:  
   `http://localhost:5000`

## Technologies Used

- Spring Boot
- Spring Data JPA
- Spring Security
- Lombok
- Maven
- MySQL (depending on configuration)

## Key Modules

- **controller** - Handles HTTP requests and REST API logic.
- **dto** - Contains Data Transfer Objects.
- **entity** - JPA entities mapped to the database.
- **repository** - Spring Data interfaces for database operations.
- **service** - Business logic and service layer.
- **mapper** - Data transformation between entities and DTOs.
- **security** - Application security configuration.
- **util** - Utility classes and helpers.
- **resources** - Application configuration and templates.

## Running Tests

```bash
./mvnw test
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
