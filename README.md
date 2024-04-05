# Spring ToDo Web Application

This is a simple todo app created to practice various Spring technologies including Spring Boot, Spring MVC, Spring Security, Spring JPA, and H2 for the initial stage. Docker and MySQL were later used for database management.

## Features

- Create, read, update, and delete todo items
- User authentication and authorization using Spring Security
- Data persistence using MySQL database
- Simple and intuitive user interface

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Spring Security
- Spring JPA
- Docker
- H2
- MySQL
- JSP
- HTML/CSS/Bootstrap

## Learning Points

- Utilized Spring MVC, Spring Boot, Spring JPA for backend development
- Learned to manage user sessions and implement security features using Spring Security
- Used Maven's pom.xml to manage project dependencies
- Configured application properties to easily switch databases (from H2 to MySQL)
- Gained experience with JSP for dynamic web page generation

## Getting Started

1. To get started with this project, clone the repository to your local machine and open it in Eclipse IDE.
2. Download Docker Desktop and install it.
3. Open a terminal and paste the following command to run a MySQL container:

   ```bash
   docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=todos-user --env MYSQL_PASSWORD=dummytodos --env MYSQL_DATABASE=todos --name mysql --publish 3306:3306 mysql:8

3. You can now run the application.

Note: To access the MySQL database, download MySQL Shell from your browser and then use the following commands:

mysqlsh
\connect todos-user@localhost:3306
\sql
use todos
select * from todo;
\quit



