# Project Assignment Web App


### Introduction

This web app allows employers to assign employees projects. It supports CRUD operations, such as add employee/project, delete, edit, etc.
It also has authorization and authentication functionalities built in, and it encrypts the password and stored it in a PostgreSQL database.
The ORM used was orignally Hibernate, but later on switched to mostly Spring Data JPA due to its less volumn of code required. The front end
web pages are written in Thymeleaf.

### Achievements

This project is a demo of my understanding of Spring (MVC, Boot). Additionally, it also shows my grasp on how to design the back end services for a 
modern full-stack project. I used a ton of features in the Spring framework, such as Spring Data JPA, Spring Security, etc. Through using these tools,
I learned how to manage entities, how to access the database tables, and how to decouple different layers with annotations as well as outside configuration files
(.xml, .yml).

### Instruction to use

- Clone the repository to local
- Import the maven project to STS/Intellj IDEA
- Configure the port (default 8080), and make sure no other program is using it
- Ready to run!
