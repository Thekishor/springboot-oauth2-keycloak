![Screenshot 2025-06-19 231526](https://github.com/user-attachments/assets/b64df1fd-7593-46e4-8871-7c0ee4aa3225)# springboot-oauth2-keycloak
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

## Screenshots

## keycloak
![keycloak](https://github.com/user-attachments/assets/acf869f0-ed88-4ab0-b20a-c4f77018f6f9)

## Token Generate
![access and refresh token](https://github.com/user-attachments/assets/35f05c53-5001-4fed-b7e6-37a3c15444fa)


## Get All Users
![get all user](https://github.com/user-attachments/assets/a0b6e78d-e7fd-41b0-9f3e-aa1f55e23f80)

## Get User By Id
![get user by userId](https://github.com/user-attachments/assets/6b5f6561-2813-4467-9e34-e48c5c221e18)

## Unauthorized User
![withiut access token](https://github.com/user-attachments/assets/0d1010e3-787b-4049-9393-cd732d76cf88)

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
