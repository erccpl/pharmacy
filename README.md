# REST Pharmacy
A REST API backend and client for managing a pharmacy.<br>
The application currently features basic CRUD operations.<br>
Project created as a means to familiarize myself with the Spring framework and related technologies.<br>

<b>Technologies: Spring Boot, Spring Security, Spring JPA, JWT, Hibernate, PostgreSQL, Thymeleaf, Maven </b>

## Authentication
The project uses JWTs as a means of authenticating users and grating them resource acces based on assigned roles.

## Usage
A user may log in as an admin or normal user.<br>
There is a simple navigation panel set up to view products and their current inventories.<br>
Currently the only distinction between a normal user and an admin is that an admin may delete products, which a normal user cannot.<br>
Both normal users and admins can add new products and update them as well as view current inventories.<br>


## Launch Instructions
To see how the application works, run the follwing command in both the pharmacy-backend and pharmacy-client directories:
```Java
mvn clean install
```
This will generate the respective .jar files which can be then run from the target directories:
```Java
java -jar pharmacy-backend/target/pharmacy-0.0.1-SNAPSHOT.jar       //runs on port 8080
java -jar pharmacy-client/target/pharmacy-client-0.0.1-SNAPSHOT.jar //runs on port 8081
```
At the moment for this would also require a locally hosted PostgreSQL database (eventually I would like to have the app connect to an externally hosted database).

Example credentials: Admin is admin:admin, Normal user is a:a
