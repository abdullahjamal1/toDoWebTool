# toDoWebTool
A task management site that displays the list of existing tasks and allows the user to add new tasks, update and delete existing tasks from the database.

## supports 

* CRUD operations.
* filtering tasks by their status ,priority , create date and due date.
* searching from database based on keywords.

## Table of contents

  * [Application Screenshots](#application-screenshots)
  * [Tech stack & Open-source libraries](#tech-stack---open-source-libraries)
    + [Data](#data)
    + [Client - Frontend/UI](#client---frontend-ui)
    + [Server - Backend](#server---backend)
    + [Libraries and Plugins](#libraries-and-plugins)
    + [Others](#others)
  * [To-Do](#to-do)
  * [Running the application locally](#running-the-application-locally)
  * [Running the application with IDE](#Running-the-application-with-IDE)
  * [Running the application with Maven](#Running-the-application-with-Maven)
  * [EER Diagram](#EER-Diagram)
  * [Packages](#Packages)

## Application Screenshots

![home page](https://github.com/aj941ga/toDoWebTool/blob/master/snapShots/home_page.PNG)
![](https://github.com/aj941ga/toDoWebTool/blob/master/snapShots/filter.PNG)

## Tech stack & Open-source libraries

### Data

* 	[MySQL](https://www.mysql.com/) - Open-Source Relational Database Management System

### Client - Frontend/UI

* 	[Thymeleaf](https://www.thymeleaf.org/) - Modern server-side Java template engine for both web and standalone environments.

### Server - Backend

* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[Maven](https://maven.apache.org/) - Dependency Management

###  Libraries and Plugins

* 	[Thymeleaf With Dialect](https://github.com/Antibrumm/thymeleaf-extras-with-dialect) - A dialect for Thymeleaf that allows you to use attributes with a "with" prefix to avoid having long "th:with"-expressions.
* 	[Thymeleaf Layout Dialect](https://github.com/ultraq/thymeleaf-layout-dialect) - A dialect for Thymeleaf that lets you build layouts and reusable templates in order to improve code reuse.

### Others 

* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system

### To-Do


## Running the application locally

*	You need to have **MySQL** installed on your machine to run the application on **`dev`** profile. Using the `MySQL Workbench` or on any other MySQL client/console, create a database/schema named `crud`. 

~~~sql
-- create schema
CREATE SCHEMA crud;

-- use schema
USE crud;

-- Create user 
create user 'crud'@'localhost' identified by 'crud';

-- Grant privileges to user
grant all privileges on *.* to 'crud'@'localhost' with grant option;
~~~

* 	URL to access application UI: **http://localhost:8080/*

### Running the application with IDE

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `TaskMain.java` class from your IDE.

* 	Download the zip or clone the Git repository.
* 	Unzip the zip file (if you downloaded one)
* 	Open Command Prompt and Change directory (cd) to folder containing pom.xml
* 	Open Eclipse
	* File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
	* Select the project
* 	Choose the Spring Boot Application file (search for @SpringBootApplication)
* 	Right Click on the file and Run as Java Application

### Running the application with Maven

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
$ git clone https://github.com/aj941ga/toDoWebTool.git
$ cd toDoWebTool
$ mvn spring-boot:run
```

## EER Diagram

![EER diagram](https://github.com/aj941ga/toDoWebTool/blob/master/snapShots/database.PNG)
## Packages

*   `api` - API utilities;
* 	`controllers` - to listen to the client;
* 	`service` - to hold business logic;
* 	`util` - to hold our utility classes;

* 	`resources/` - Contains all the static resources, templates and property files.
* 	`resources/static` - contains static resources such as css, js and images.
* 	`resources/templates` - contains server-side templates which are rendered by Spring.
* 	`resources/application.properties` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.

* 	`pom.xml` - contains all the project dependencies





