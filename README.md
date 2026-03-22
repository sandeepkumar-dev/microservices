# 🚀 Microservices Architecture with Spring Boot

This project demonstrates a **Microservices Architecture** built using **Spring Boot**, implementing **Service Discovery**, **Centralized Monitoring**, and **Actuator-based health tracking**.

---

## 🧩 Project Modules

* **eureka-server** → Service Registry using Netflix Eureka
* **admin-server** → Monitoring dashboard using Spring Boot Admin
* **microservice1** → Sample microservice (Port: 8081)
* **microservice2** → Sample microservice (Port: 8082)

---

## ⚙️ Technologies Used

* Java 25
* Spring Boot
* Spring Cloud (Netflix Eureka)
* Spring Boot Admin
* Spring Boot Actuator
* Maven

---

## 🏗️ Architecture Overview

```
                +---------------------+
                |   Admin Server      |
                |     (Port 8080)     |
                +----------+----------+
                           |
                           |
        +------------------+------------------+
        |                                     |
+-------+--------+                    +--------+--------+
| Microservice1  |                    | Microservice2  |
|   (Port 8081)  |                    |   (Port 8082)  |
+-------+--------+                    +--------+--------+
        |                                     |
        +------------------+------------------+
                           |
                   +-------+--------+
                   |  Eureka Server |
                   |   (Port 8761)  |
                   +----------------+
```

---

## 🔍 Features

✅ Service Registration & Discovery using Eureka
✅ Centralized Monitoring using Spring Boot Admin
✅ Health Checks via Actuator Endpoints
✅ Multiple Microservices running independently
✅ Real-time status tracking (UP/DOWN)

---

## ▶️ How to Run

### Step 1: Start Eureka Server

```
cd eureka-server
mvn spring-boot:run
```

👉 Open: http://localhost:8761

---

### Step 2: Start Admin Server

```
cd admin-server
mvn spring-boot:run
```

👉 Open: http://localhost:8080

---

### Step 3: Start Microservices

#### Microservice 1

```
cd microservice1
mvn spring-boot:run
```

#### Microservice 2

```
cd microservice2
mvn spring-boot:run
```

---

## 📊 Monitoring

Access Spring Boot Admin Dashboard:

👉 http://localhost:8080

* View all services
* Check health status
* Monitor endpoints

---

## 🧪 Actuator Endpoints

Example:

```
http://localhost:8081/actuator/health
http://localhost:8082/actuator/health
```

---

## 💡 Key Learnings

* Handling service registration issues
* Fixing actuator endpoint misconfigurations
* Debugging microservices communication
* Managing distributed system components

---

## 🚀 Future Enhancements

* API Gateway (Spring Cloud Gateway)
* Feign Client for inter-service communication
* JWT Authentication & Authorization
* Docker & Kubernetes deployment

---

## 👨‍💻 Author

**Sandeep Kumar**
Full Stack Developer

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!
