# SpringBoot Backend
#### ASC-IITB

## Overview

This is the backend service for the assignment, built using Spring Boot. It provides RESTful APIs for managing courses and instances of the course and connects to a PostgreSQL database.

## Prerequisites

Before running the project, ensure you have the following installed:

- [Java 17 or higher](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/download.cgi) (for building the project)
- [Docker](https://www.docker.com/get-started) (for containerization)
- [PostgreSQL](https://www.postgresql.org/download/) (for database management)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/racchittt/backend-iitb
cd backend-iitb
```

### 2. Create a SQL database
```bash
CREATE DATABASE iitb;
```
### 3. Build the project
```bash
mvn clean install
```

### 4. Change application.properties to configure PostgreSQL
Open the application.properties file in ```/src/main/resources``` and replace the first 3 lines as
```bash
spring.datasource.url=${SPRING_DATASOURCE_URL:jdbc:postgresql://localhost:5432/db_name}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME:username}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD:password}
# replace the username and password with your postgres credentials
# db_name should be replaced with iitb or the name you created your database with
```

### 5. Run the application
```bash
mvn spring-boot:run
```
OR

Use VSCode / Eclipse and open the project. Go to DemoApplication.java file in the ```src/main/java/com/example/demo``` directory and click on the ```Run``` to run it as a Java Application. The Run button is present above the static class shown below.
```bash
public static void main(String args[])
```

### 6. Access the Application
Backend service is accessible at http://localhost:8080
```bash
API END POINTS

For Courses
    POST /api/courses: Add a new course
    GET /api/courses: Get all courses
    GET /api/courses/{id}: Get course by ID
    DELETE /api/courses/{id}: Delete a course by ID

For Instances
    POST /api/instances: Add a new instance
    GET /api/instances: Get all instances
    GET /api/instances/{year}: Get instances by year
    GET /api/instances/{year}/{sem}: Get instance by year and Sem
    GET /api/instances/{year}/{sem}/{courseId}: Get instance by year, sem and courseId
    DELETE /api/instances/{year}/{sem}/{courseId}: Delete a instance by ID
```

### Technologies used
1. Spring Boot
2. Maven
3. JPA
4. JDBC

## Additional Notes

- Ensure that the PostgreSQL configuration in the application.properties is correct
- Confirm that PostgreSQL server is running.