# Portfolio — Project Context

## Overview
Personal portfolio website for Amantii Samson, a Senior Software Engineer based in Charlotte, NC.
Full-stack application showcasing professional experience, projects, and skills.
Built to be hosted publicly and linked from resume and LinkedIn.

## Tech Stack

### Frontend
- **Framework:** Angular 21 (standalone components, no NgModule, Signals-first)
- **Language:** TypeScript
- **Styling:** Angular Material or custom SCSS
- **HTTP:** Angular HttpClient with RxJS Observables
- **Build:** Angular CLI (Vite + ESBuild)

### Backend
- **Framework:** Java 21 + Spring Boot 4.0.5
- **Spring Framework:** 7.x
- **API style:** RESTful JSON
- **ORM:** Spring Data JPA (Hibernate 7, Jakarta EE 11)
- **Migrations:** Flyway
- **Build tool:** Maven

### Database
- **Engine:** PostgreSQL
- **Tables:** `projects`, `contact_messages`, `page_views`

### Monorepo Structure
```
amantii-portfolio/
├── frontend/          # Angular app
├── backend/           # Spring Boot app
├── CLAUDE.md          # This file
└── README.md
```

---

## Frontend Structure

```
frontend/src/app/
├── core/
│   ├── services/
│   │   ├── projects.service.ts       # GET /api/projects
│   │   ├── contact.service.ts        # POST /api/contact
│   │   └── analytics.service.ts     # POST /api/views
│   └── models/
│       ├── project.model.ts
│       └── contact-message.model.ts
├── features/
│   ├── hero/
│   ├── projects/
│   ├── experience/
│   ├── skills/
│   └── contact/
└── shared/
    └── components/
        ├── skill-chip/
        └── project-card/
```

### Angular Conventions
- Use standalone components (`standalone: true`) — no NgModule
- Services use `providedIn: 'root'`
- Prefer **Signals** (`signal()`, `computed()`, `effect()`) for state management over RxJS where possible — Angular 21 recommended approach
- All HTTP calls return `Ob change detection — Angular 21 no longer requires Zone.js
- Environments in `src/environments/environment.ts` and `environment.prod.ts`
- API base URL comes from environment file, never hardcoded

---

## Backend Structure

```
backend/src/main/java/com/amantii/portfolio/
├── controller/
│   ├── ProjectController.java        # GET /api/projects
│   ├── ContactController.java        # POST /api/contact
│   └── AnalyticsController.java      # POST /api/views
├── service/
│   ├── ProjectService.java
│   ├── ContactService.java
│   └── AnalyticsService.java
├── repository/
│   ├── ProjectRepository.java        # extends JpaRepository<Project, Long>
│   ├── ContactRepository.java
│   └── PageViewRepository.java
├── entity/
│   ├── Project.java
│   ├── ContactMessage.java
│   └── PageView.java
├── dto/
│   ├── ProjectDto.java
│   └── ContactRequestDto.java
└── config/
    └── CorsConfig.java               # Allows requests from Angular domain
```

### Spring Boot Conventions
- Controllers are thin — delegate all logic to services
- Never return `@Entity` objects directly from controllers — always map to DTOs
- Use `@RestController` and `@RequestMapping("/api")`
- Validation with `@Valid` and Bean Validation 3.1 annotations on DTOs
- Use `jakarta.*` package names — Spring Boot 4 / Spring Framework 7 are fully on Jakarta EE 11 (not `javax.*`)
- CORS configured in `CorsConfig.java` to allow Angular dev (localhost:4200) and prod domain
- `application.properties` for config; secrets via environment variables (never hardcoded)
- Virtual threads available via Java 21 — can enable with `spring.threads.virtual.enabled=true`

---

## Database Schema

### `projects`
```sql
CREATE TABLE projects (
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    github_url  VARCHAR(255),
    live_url    VARCHAR(255),
    tags        TEXT[],
    featured    BOOLEAN DEFAULT FALSE,
    sort_order  INT DEFAULT 0,
    created_at  TIMESTAMP DEFAULT NOW()
);
```

### `contact_messages`
```sql
CREATE TABLE contact_messages (
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    message    TEXT NOT NULL,
    sent_at    TIMESTAMP DEFAULT NOW()
);
```

### `page_views`
```sql
CREATE TABLE page_views (
    id          SERIAL PRIMARY KEY,
    path        VARCHAR(255),
    referrer    VARCHAR(255),
    visited_at  TIMESTAMP DEFAULT NOW()
);
```

Migrations live in `backend/src/main/resources/db/migration/` as `V1__init.sql`, `V2__...`, etc.

---

## API Endpoints

| Method | Path | Description |
|--------|------|-------------|
| GET | /api/projects | Returns all projects ordered by sort_order |
| POST | /api/contact | Saves a contact form submission |
| POST | /api/views | Logs a page view |

---

## Key People & Context
- **Owner:** Amantii Samson — Senior Software Engineer at General Motors (Charlotte, NC area)
- **Enterprise Angular experience:** CAM system (50+ apps, Angular v13→18) and D2C2 (dealer platform, 200+ features)
- **Side projects:** CourtCompanion (AI legal guidance app, Next.js/FastAPI/Claude API) and Northlight Living (affordable housing)
- **Purpose of this portfolio:** Public-facing site linked from resume and LinkedIn; demonstrates full-stack Angular + Spring Boot + PostgreSQL skills to prospective employers and recruiters

---

## Dev Setup

### Frontend
```bash
cd frontend
npm install
ng serve          # runs on localhost:4200
```

### Backend
```bash
cd backend
./mvnw spring-boot:run    # runs on localhost:8080
```

### Database (local)
```bash
# Assumes PostgreSQL is running locally
createdb portfolio_db
# Flyway runs migrations automatically on backend startup
```

### Environment Variables (backend)
```
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/portfolio_db
SPRING_DATASOURCE_USERNAME=your_user
SPRING_DATASOURCE_PASSWORD=your_password
```

---

## What NOT to do
- Do not use NgModule — all components are standalone
- Do not use `subscribe()` in templates — use AsyncPipe or Signals
- Do not use `javax.*` imports — Spring Boot 4 uses `jakarta.*` exclusively
- Do not return JPA entities from REST controllers — use DTOs
- Do not hardcode API URLs — use environment files
- Do not use `sudo npm install`
- Do not commit secrets or API keys
- Do not use Zone.js — Angular 21 is zoneless by default
