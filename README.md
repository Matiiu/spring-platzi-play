# Platzi Play 🎬  

Platzi Play is a **Spring Boot 3** application that manages movies with full **CRUD functionality** (Create, Read, Update, Delete).  
It uses **PostgreSQL** as the database, includes **API documentation with Swagger**, and integrates tools for validation, testing, and code mapping.  

Additionally, Platzi Play uses **LangChain4j** 🤖 to provide **AI-powered movie recommendations** based on user preferences.

### 🚀 Features
	•	✅ Create, edit, delete, and list movies
	•	✅ PostgreSQL database integration
	•	✅ API documentation with Swagger UI
	•	✅ Validation with Spring Boot Starter Validation
	•	✅ Entity mapping with MapStruct
	•	✅ Unit tests with JUnit & Mockito
	•	✅ LangChain4j integration for future AI features

### 🛠️ Tech Stack
	•	Java 21
	•	Spring Boot 3.5.4
	•	Spring Data JPA
	•	PostgreSQL
	•	Swagger (OpenAPI)
	•	MapStruct
	•	LangChain4j
	•	JUnit 5 & Mockito

### 📦 Dependencies
####  Main dependencies used in the project:
	•	spring-boot-starter-web → REST API development
	•	spring-boot-starter-data-jpa → Database persistence with JPA
	•	postgresql → PostgreSQL driver
	•	spring-boot-starter-validation → Input validation
	•	springdoc-openapi-starter-webmvc-ui → Swagger UI for API documentation
	•	mapstruct → Object mapping (DTOs ↔ Entities)
	•	langchain4j → AI integration (OpenAI & Spring Boot starter)
	•	junit, mockito-inline → Testing

### ⚙️ Setup & Run
#### 1️⃣ Clone repository

```bash
git clone https://github.com/your-username/platzi-play.git
cd platzi-play
```

#### 2️⃣ Configure Database

Make sure you have PostgreSQL running.
Update your application.properties (or application.yml) with your database credentials:

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/platzi_play
spring.datasource.username=your_user
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update```

#### 3️⃣ Build & Run
```bash
./gradlew bootRun
```

The application will start at:
👉 http://localhost:8090/platzi-play

### 🎯 API Documentation
Swagger UI is enabled for interactive API testing:
👉 http://localhost:8090/platzi-play/api/swagger-ui.html

### 🗂️ CRUD Endpoints

| Method   | Endpoint          | Description              |
|----------|-------------------|--------------------------|
| `GET`    | `/movies`         | Get all movies           |
| `GET`    | `/movies/{id}`    | Get a movie by ID        |
| `POST`   | `/movies`         | Create a new movie       |
| `PUT`    | `/movies/{id}`    | Update a movie           |
| `DELETE` | `/movies/{id}`    | Delete a movie           |
| `GET`    | `/movies/suggest` | Suggest a movie with AI  |
