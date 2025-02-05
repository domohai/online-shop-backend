# Online shop backend project
A Spring Boot web application for an online shop, providing APIs for user, product, and cart management. 
The backend is built following the Spring MVC architecture and uses MongoDB as the database. 
The application is fully dockerized, including a MongoDB container, making it deployable on Docker Hub or any other containerized environment.

# Development
## Prerequisites
### Clone the repository
```bash
git clone https://github.com/domohai/online-shop-backend.git
```

### Utitlities Dependencies
- OpenJDK 23
- Docker installed in local

### Create your own `.env` file
```bash
# MongoDB Credentials (Root User)
MONGO_INITDB_ROOT_USERNAME=
MONGO_INITDB_ROOT_PASSWORD=
MONGO_DATABASE=
MONGO_PORT=
MONGO_HOST= # The service name in docker-compose

# Spring Boot App
SPRING_PORT=
```
