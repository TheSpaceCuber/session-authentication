# Restful Session Authentication and Authorization using java 17, Spring Boot 3.1.0 and MySQL

### Prerequisite
- Docker

### Quickstart
To use this project, you'll need docker to get the latest versions of MySQL  and Java IDE with Maven support. 
Clone the repository and import the project into your IDE. 

```bash
'To get the application running' 
* docker compose up -d
* ./mvnw clean spring-boot:run
```

Edit `application-dev.properties`:
```properties
# on first setup, use `always` instead of `never` to initialize tables
spring.session.jdbc.initialize-schema=never
```
### Description
This project implements session authentication for a web application using Spring Security and MySQL as the session 
storage. Users can register and log in using their email and password, and access different parts of the application 
based on their role.

### Features
* Register, Login and Logout using restful APIs.
* Email and password authentication
* Role based authorization
* Testing using test containers

### Fork
This is a fork of [this repo](https://github.com/iTchTheRightSpot/session-authentication) which uses redis for session storage instead of mysql. I've edited this repo to use `spring-session-jdbc` instead to store sessions in a relational database (sql). There will be no use of redis.

Notable changes include:
- Using `JdbcIndexedSessionRepository` instead of `RedisIndexedSessionRepository`
- `spring.session.timeout=10s` means that inactivity of 10s requires re-login
-   `spring.session.store-type=jdbc`
- `spring.session.jdbc.initialize-schema=never` Note that this should be set to `always` on the first run to initialize the tables. But once they are up in the db, then `never` is the correct setting.


### Postman
A postman collection is included for your convenience at `./spring_session.postman_collection.json`

### Dependencies
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#appendix.configuration-metadata.annotation-processor)
* [Spring Session](https://docs.spring.io/spring-session/reference/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#web)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#web.security)
* [Validation](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#io.validation)
