# jpaRelationship

A Spring Boot project that demonstrates a **JPA relationship between Student and Department** (many students belong to one department), exposed through simple REST APIs.

## Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- Maven
- MySQL (or any relational DB configured in `application.properties`)
- Postman (for API testing)

## Project Structure

```
src/main/java/com/example
├── controller
│   ├── DepartmentController.java
│   └── StudentController.java
├── entity
│   ├── Department.java
│   └── Student.java
├── repository
│   ├── DepartmentRepository.java
│   └── StudentRepository.java
├── services
│   ├── DepartmentServices.java
│   └── StudentServices.java
└── JpaRelationshipApplication.java

src/main/resources
└── application.properties
```

## Entity Relationship

```
Department (1) <------ (Many) Student
```

- `Student` has a `@ManyToOne` reference to `Department`.
- `Department` can have many students (`@OneToMany`, mapped by `department`).

## Setup

1. Clone the project and open it in IntelliJ IDEA.
2. Create a database, for example:
   ```sql
   CREATE DATABASE jpa_relationship;
   ```
3. Configure `src/main/resources/application.properties`:
   ```properties
   server.port=8081

   spring.datasource.url=jdbc:mysql://localhost:3306/jpa_relationship
   spring.datasource.username=root
   spring.datasource.password=your_password

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```
4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
   The app starts at `http://localhost:8081`.

## API Endpoints

Base URL: `http://localhost:8081/api/student`

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/withDepartment?deptName=Sells&id=8` | Create a student and attach it to an existing department by name. The student id is passed in the URL. |

> Update this table to match the exact mappings in `StudentController` and `DepartmentController`.

### Example: Create a student with a department

**Request**

```
POST http://localhost:8081/api/student/withDepartment?deptName=Sells&id=8
Content-Type: application/json
```

**Body**

```json
{
  "name": "Vishal"
}
```

**Response**

```json
{
  "id": 8,
  "name": "Vishal",
  "department": {
    "id": 1,
    "name": "Sells"
  }
}
```

## Testing with Postman

1. Set the method to **POST**.
2. Enter the URL with query params (`deptName`, `id`).
3. Go to **Body → raw → JSON** and add the student JSON.
4. Click **Send**.
 
