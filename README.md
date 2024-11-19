# Wellness360Intern
The **Task Management API** is a Spring Boot application that provides a RESTful API for managing tasks. It supports CRUD operations, marking tasks as complete, and validating user input.

---

## Features

- Create, Read, Update, and Delete (CRUD) tasks.
- Mark tasks as complete.
- Input validation for task properties.
- Error handling with meaningful responses.
- Secured with basic authentication.
- Auto-managed timestamps (`createdAt` and `updatedAt`).

---

## Technologies Used

- **Java 17**
- **Spring Boot** (REST, Validation)
- **Spring Data JPA** (ORM)
- **MySQL** (Database)
- **JUnit 5** (Unit Testing)
- **Mockito** (Mocking in Unit Tests)

---

## Get Started

### Prerequisites

- **Java 17** installed.
- **Maven** installed.
- **MySQL** installed and running.

### Clone the Repository

```bash
git clone: https://github.com/Ksanjeev7/Wellness360Intern
```
## Configuration

### DataBase Setup

- Create DataBase task_manager; 

- Update src/main/resources/application.properties with your MySQL credentials:

  - spring.datasource.url=jdbc:mysql://localhost:3306/task_manager_db
  - spring.datasource.username=your-username
  - spring.datasource.password=your-password
  - spring.jpa.hibernate.ddl-auto=update
  - spring.jpa.show-sql=true


