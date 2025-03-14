# Project Overview
This project is a Java application that manages Aikido training sessions, instructors, and students. It uses Jakarta Persistence (JPA) for ORM and is built with Maven.

## Setup Instructions
Clone the repository:
```sh
git clone https://github.com/yourusername/your-repo-name.git
cd your-repo-name
```
Build the project using Maven:
```sh
mvn clean install
```
Run the project:
```sh
mvn exec:java -Dexec.mainClass="Main"
```

Ensure that you have a database setup and update the `persistence.xml` file with your database connection details.

# Dependencies
- Java 11
- Maven 3.6+
- Jakarta Persistence Api (JPA)
- Database (MySQL, PostgreSQL, etc.)