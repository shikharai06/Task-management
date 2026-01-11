# 📝 Task Management System – Spring Boot (DDD + TDD)

A simplified **Task Management REST API** built using **Spring Boot**, following **Domain-Driven Design (DDD)** principles with a strong focus on **clean code**, **testability**, and **best practices**.

This project is designed as an **interview-ready backend assignment** demonstrating proper layering, validation, error handling, and RESTful API design.

---

## 🚀 Features

- Create, update, retrieve, and delete tasks
- Task status management (`PENDING`, `IN_PROGRESS`, `DONE`)
- Due date validation (must be today or a future date)
- Pagination and filtering by task status
- Global exception handling
- In-memory data storage (no database)
- Clean layered architecture (DDD inspired)
- Unit-test and integration-test friendly design

---

## 🧱 Tech Stack

- Java 17  
- Spring Boot  
- Maven  
- REST APIs   
- Git & GitHub  

---

## 🧩 Task Domain Model

Each **Task** contains the following fields:

| Field        | Type          | Description |
|-------------|--------------|-------------|
| id          | String        | Auto-generated unique identifier |
| title       | Value Object  | Required |
| description | String        | Optional |
| status      | Enum          | PENDING / IN_PROGRESS / DONE |
| dueDate     | Value Object  | Required, must not be a past date |

---

## 🏗️ Project Structure (DDD Inspired)

```
src/main/java/com/app
│
├── controller
│   └── TaskController.java
│
├── dto
│   ├── CreateTaskRequest.java
│   ├── UpdateTaskRequest.java
│   ├── TaskResponse.java
│   └── ErrorResponse.java
│
├── service
│   ├── ITaskService.java
│   └── TaskServiceImpl.java
│
├── repository
│   ├── ITaskRepository.java
│   └── TaskRepository.java
│
├── model
│   ├── entity
│   │   └── Task.java
│   ├── valueobject
│   │   ├── TaskId.java
│   │   ├── TaskTitle.java
│   │   └── DueDate.java
│   └── TaskStatus.java
│
├── exception
│   ├── TaskNotFoundException.java
│   └── GlobalExceptionHandler.java
│
└── TaskManagementApplication.java
```

---

## 🌐 REST API Endpoints

### ➕ Create Task
```
POST /tasks
```

Request Body:
```json
{
  "title": "Learn Spring Boot task 1",
  "description": "DDD + DTO + Clean code",
  "due_date": "2027-11-11"
}
```

---

### 🔍 Get Task by ID
```
GET /tasks/{id}
```

---

### ✏️ Update Task
```
PUT /tasks/{id}
```

---

### ❌ Delete Task
```
DELETE /tasks/{id}
```

---

### 📄 List All Tasks (Pagination + Filtering)
```
GET /tasks?page=0&size=5&status=PENDING
```

---

## ⚠️ Error Handling

- `400 BAD REQUEST` → Validation errors
- `404 NOT FOUND` → Task not found
- Centralized exception handling using `@ControllerAdvice`

---



## ▶️ Run the Application

```bash
mvn spring-boot:run
```

Application runs at:
```
http://localhost:8080
```

---

## 👩‍💻 Author

**Shikha Rai**  
Java Backend Developer  
Spring Boot | Clean Code | Domain-Driven Design
