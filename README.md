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

## Project Architecture

- **Controller Layer**: Handles HTTP requests and maps them to service methods.
- **Service Layer**: Contains business logic.
- **Repository Layer**: Manages database interactions using JPA.
- **Model Layer**: Represents the task entity with validation and lifecycle methods.

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

## Run the Application
- mvn spring-boot : run

## Testing Instructions

Run the unit tests using Maven:
```bash
mvn test
```

## Access the Api at: 
``
http://localhost:8080
``

## API Endpoints

The Task Management API provides the following endpoints:

| HTTP Method | Endpoint               | Description                        | Request Body Example | Response Example |
|-------------|------------------------|------------------------------------|----------------------|------------------|
| **GET**     | `/tasks`               | Retrieve all tasks                | N/A                  | `[{"id":1,"title":"Task 1",...}]` |
| **GET**     | `/tasks/{id}`          | Retrieve a specific task by ID    | N/A                  | `{"id":1,"title":"Task 1",...}` |
| **POST**    | `/tasks`               | Create a new task                 | `{...}`              | `{"id":1,"title":"New Task",...}` |
| **PUT**     | `/tasks/{id}`          | Update an existing task           | `{...}`              | `{"id":1,"title":"Updated Task",...}` |
| **DELETE**  | `/tasks/{id}`          | Delete a task                     | N/A                  | `204 No Content` |
| **PATCH**   | `/tasks/{id}/complete` | Mark a task as complete           | N/A                  | `{"id":1,"status":"COMPLETED",...}` |

---

### Request and Response Examples

#### **GET `/tasks`**
**Description:** Retrieves all tasks.

**Example Response:**
```json
[
  {
    "id": 1,
    "title": "Task 1",
    "description": "Description for Task 1",
    "dateTime": "2024-12-01",
    "status": "PENDING",
    "createdAt": "2024-11-19T12:00:00",
    "updatedAt": "2024-11-19T12:00:00"
  }
]

```

## Future Enhancements

- Implement JWT-based authentication for enhanced security.
- Add task filtering and sorting by status and due date.
- Develop a web frontend or mobile app for easier task management.
- Implement email notifications for overdue tasks.

## License
This project is licensed under the MIT License. Feel free to use, modify, and distribute.

## Author 
Created by @SanjeevK ... For any questions, Modifications or issues contact [sanjeevkadagandla61@gmail.com] 
