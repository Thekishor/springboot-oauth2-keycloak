# springboot-oauth2-keycloak
# User Service - Spring Boot OAuth2 + Keycloak

This is a **User Management Microservice** built with **Spring Boot** and secured using **OAuth2** and **Keycloak**. It allows clients to perform basic CRUD operations on users, as well as fetch users by address.

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Security (OAuth2 Resource Server)
- Keycloak (OAuth2 Identity Provider)
- Maven 
- PostgreSQL

---

##  Features

- Create a new user
- Get user by ID
- Get all users
- Update user by ID
- Delete user by ID
- Get users by address

---

## Security

All endpoints are protected using **OAuth2 Bearer Tokens** (JWT) issued by **Keycloak**.

- Only authenticated users can access user endpoints.

---

##  API Endpoints

| Method | Endpoint                  | Description           | 
|--------|-------------------------- |-----------------------|
| POST   | `/user/create`            | Create new user       | 
| GET    | `/user/{userId}`          | Get user by ID        |
| GET    | `/user`                   | Get all users         | 
| PUT    | `/user/{userId}`          | Update user by ID     | 
| DELETE | `/user/{userId}`          | Delete user by ID     | 
| GET    | `/user/address/`          | Get users by address  | 

---

## Configuration

Update your `application.yml` (or `application.properties`) with appropriate Keycloak settings:

```yaml
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: http://localhost:8180/realms/{your-realm-name}
