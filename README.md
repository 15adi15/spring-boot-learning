# Spring Boot OAuth 2.0 & OpenID Connect (OIDC) MasterClass

A hands-on Spring Boot project exploring modern authentication and authorization using **OAuth 2.0** and **OpenID Connect (OIDC)**, custom user persistence, and Spring Security.

---

## 🚀 Overview

This repository documents the development journey of building a production-grade authentication flow with Spring Boot:
- Integration with external OAuth2/OIDC identity providers (e.g., Google, GitHub).
- Custom `OAuth2UserService` to intercept authentication and automatically register or update user profiles in a relational database.
- Declarative security rules using Spring Security Filter Chain.
- Stateless and session-managed user profile management.

---

## 🛠️ Tech Stack

- **Language:** Java 25
- **Framework:** Spring Boot 4.x / Spring Security
- **OAuth2/OIDC:** `spring-boot-starter-security-oauth2-client`
- **Database:** PostgreSQL with Spring Data JPA & Hibernate
- **Build Tool:** Maven

---

## 📐 Architecture & Authentication Flow

```
+----------+          +-------------------------+          +------------------+
|          |  (1)     |                         |  (2)     |                  |
|  Client  | -------->| Spring Security Filter  | -------->|  OAuth2 / OIDC   |
| (Browser)|          |       (OAuth2 Login)    |          |     Provider     |
+----------+          +-------------------------+          +------------------+
                                  |                                  |
                                  | (3) Intercept OidcUser           |
                                  v                                  v
                      +-------------------------+          (ID Token / Claims)
                      |  CustomOidcUserService  |
                      +-------------------------+
                                  |
                                  | (4) Sync / Register
                                  v
                      +-------------------------+
                      |       UserService       |
                      +-------------------------+
                                  |
                                  | (5) Save / Update
                                  v
                      +-------------------------+
                      |   PostgreSQL Database   |
                      +-------------------------+
```

1. **User requests protected resource** -> Redirected to Identity Provider (Google/GitHub).
2. **Provider authenticates user** -> Issues ID token containing user profile claims (`sub`, `name`, `email`).
3. **`CustomOidcUserService` intercepts login** -> Extracts provider identity (`providerSubject`).
4. **`UserService` synchronizes data** -> Finds existing user or creates a new user record.
5. **Session is established** -> Authenticated context is available to controller endpoints.

---

## 📂 Project Structure

```
src/main/java/com/example/oAuth2/__MasterClass/
├── Application.java
├── Config/
│   └── SecurityConfig.java          # SecurityFilterChain and OAuth2 login wiring
├── Entity/
│   └── User.java                    # JPA Entity storing user details & provider sub
├── Repository/
│   └── UserRepository.java          # Spring Data JPA queries
├── Service/
│   ├── CustomOidcUserService.java   # Custom OAuth2UserService for OIDC claims
│   └── UserService.java             # User upsert logic
└── Controller/
    └── UserController.java          # User profile endpoints
```

---

## ⚙️ Setup & Running Locally

### 1. Prerequisites
- Java 25+
- PostgreSQL instance running locally or via Docker

### 2. Configure Environment Variables
Set your database and OAuth2 provider credentials without hardcoding them into source control:

```bash
export DB_URL=jdbc:postgresql://localhost:5432/oauth2_db
export DB_USERNAME=postgres
export DB_PASSWORD=your_password

export GOOGLE_CLIENT_ID=your-google-client-id
export GOOGLE_CLIENT_SECRET=your-google-client-secret
```

### 3. Build & Run
```bash
./mvnw clean compile
./mvnw spring-boot:run
```

---

## 🗺️ Roadmap & Milestones

- [x] Spring Security OAuth2 client setup
- [x] User Entity & JPA Repository for OAuth identities
- [x] Custom `OidcUserService` integration for claim interception
- [x] Idempotent user registration/sync logic (`registerOrUpdate`)
- [ ] User profile REST endpoints (`/api/me`)
- [ ] Multi-provider support (Google + GitHub)
- [ ] Role-Based Access Control (RBAC) & Custom Authorities
- [ ] JWT token issuance for SPA / Mobile clients

---

## 👤 Author
- **Aditya Bhore**
- GitHub: [@adityasanjaybhore](https://github.com/adityasanjaybhore)
