# 📘 Build Microservices Springboot Orders & Products

## 🚀 Overview

**Build Microservices Springboot Orders & Products** is a modular Spring Boot project modeling a small e-commerce system with separate services for **orders**, **users**, **inventory**, and **shared modules**.  
The system uses **Eureka Service Discovery** to allow services to register and communicate dynamically. It demonstrates a clean microservices architecture with independent, scalable services.

---

## 🧱 System Architecture
```text

                 ┌────────────────────┐
                 │    Eureka Server   │  ← Service Registry / Discovery
                 └────────────────────┘
                             ▲
   ┌─────────────────┬───────┴───────┬─────────────────┐
   │                 │               │                 │
OrderService    InventoryService  UserService   (Shared Modules)
   │                 │               │                 │
   └─── REST APIs ─────────────────────────────────────┘

```
---

## 📦 Project Modules

### 📍 Eureka‑Server
A Spring Boot application acting as **service discovery**, enabling other services to register and discover each other at runtime.

### 📍 SharedModules
Contains shared code such as **DTOs, utility classes, common exceptions**, and configuration used across services.

### 📍 UserService
Handles **user profiles**, registration, login, and profile management.

### 📍 Inventory‑Service
Manages **product inventory** (stock levels, availability) and exposes APIs for order validation.

### 📍 OrderService
Handles **order placement and lifecycle**:
- Validates inventory before creating an order
- Tracks order status
- Maintains order history

---

## 🛠 Core Features

- **Orders**: Create, retrieve, update, and cancel orders
- **Inventory**: Track stock, update quantities, check product availability
- **Users**: Manage users (create, update, delete, retrieve)
- **Microservices Patterns**: Service discovery, independent services, shared modules
- **REST APIs**: Full CRUD support for all services

---

## 📡 REST API Endpoints (Typical)

### 🔹 UserService
| Method | Path | Description |
|--------|------|-------------|
| GET | /users | List all users |
| GET | /users/{id} | Get user by ID |
| POST | /users | Create a user |
| PUT | /users/{id} | Update a user |
| DELETE | /users/{id} | Delete a user |

### 🔹 InventoryService
| Method | Path | Description |
|--------|------|-------------|
| GET | /inventory/{productId} | Retrieve stock count |
| PUT | /inventory/{productId} | Update stock |

### 🔹 OrderService
| Method | Path | Description |
|--------|------|-------------|
| POST | /orders | Create a new order |
| GET | /orders | List all orders |
| GET | /orders/{id} | Get order by ID |
| DELETE | /orders/{id} | Cancel an order |

---

## 🔄 Inter-Service Communication

- **REST calls** (via `RestTemplate` or `FeignClient`)
- **Service discovery** using Eureka
- **Shared DTOs** to avoid duplicate code

---

## ⚙️ Technology Stack

| Layer | Technology |
|-------|------------|
| Application | Spring Boot |
| Service Discovery | Netflix Eureka |
| Communication | REST (Feign/RestTemplate) |
| Build Tool | Maven |
| Database | MySQL / H2 / MongoDB (configurable per service) |
| Serialization | Jackson |
| Shared Logic | Shared Modules |

---

## 📌 How to Run (Typical Setup)

1. **Start Eureka Server**  
```bash
cd Eureka-Server
mvn spring-boot:run
