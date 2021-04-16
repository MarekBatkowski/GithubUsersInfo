# Github Users Info

A simple RESTful Service returning github Users info as JSON file.  
Created using Spring Boot.  
Uses MySQL to count API requests for individual users.

# Getting Started

### Database setup:

This service needs a MySQL database to run and MySQL user with necessary privileges.  
```
mysql> create database db_name; -- Creates the new database
mysql> create user 'mysqluser'@'%' identified by 'password1234'; -- Creates the user
mysql> grant all on db_name.* to 'mysqluser'@'%'; -- Gives all privileges to the new user on the newly created database
```

### Changing configuration file

Open file
```
(project root)/src/main/resources/application.properties
```

Change settings accordingly:

* `server.port` to the port the app is supposed to run on (default port is 8080)
* `spring.datasource.url`to `jdbc:mysql://(db_host):(db_port)/(db_name)` where:
    * `(db_host)` is a hostname of a server a MySQL database runs on,
    * `(db_port)` is a port number a MySQL database runs on (default is 3306),
    * `(db_name)` is database name the service is supposed to connect to,
* `spring.datasource.username` to database username the service uses,
* `spring.datasource.password` to his password.

### Running the service

To run the service go to project's root and simply run:

`mvnw spring-boot:run`

Necessary database structure will be created by application itself.

To secure the database run following commands after first run:
```
mysql> revoke all on db_name.* from 'mysqluser'@'%';
mysql> grant select, insert, delete, update on db_name.* to 'mysqluser'@'%';
```

You should now be able to use the service by using GET method on endpoint URL: 

`http://(hostname):(port)/users/(github_user_login)`
