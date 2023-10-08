# Library API
## The project consists of 3 primary microservices:
- Book Service: provides api for managing books, as well as funcionality for borrowing and returning books.
- Library Service: registers all book orders with the information aboute dates when books were borrowed and when they must be returned.
- Auth Service: stores users and manages authentication.

Eureka Server is used as Service Registry, Spring Cloud Gateway is used as API Gateway, which provides a single entry point for the whole application.

## Used technologies:
- Java
- Spring Framework (Boot, Security, Data, Cloud)
- Hibernate ORM
- PostgreSQL
- Flyway
- Mapstruct
- Swagger
- RabbitMQ
- Jib
- Docker

## How to run it
I used Google Jib to containerize microservices and upload them to Docker Hub. So you just need to run the following commands:
```sh
docker compose pull
docker compose up -d
```