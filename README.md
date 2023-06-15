# AI Coding Tool Demo - Book API

## Overview

This repository contains a basic Spring Boot API application designed as a starting point for a demo of AI coding tools. It's meant to provide a concrete example of a typical Java application that can be used to demonstrate the capabilities of several AI tools, including GitHub Copilot, AWS Codewhisperer, Tabnine, and Codeium.

The "Book API" application is a simple RESTful API to manage a collection of books. It was designed with the assistance of OpenAI's ChatGPT-4. The primary purpose of this demo project is to allow an evaluation and comparison of the aforementioned AI tools in terms of their ability to understand context, generate code, assist in refactoring, and provide useful suggestions for improvements.

## Project Structure

The project is structured as a typical Spring Boot application with the following key components:

- `Domain Model`: This includes the `Book` class, representing the main entity in our application.
- `Repository`: The `BookRepository` interface extends `JpaRepository` for the `Book` entity, enabling basic CRUD operations.
- `Service`: The `BookService` class is a service layer that uses the `BookRepository` to perform operations such as adding, removing, finding, and sorting books.
- `Controller`: The `BookController` class is a REST controller that exposes endpoints to manage the books.

Additionally, the project includes both unit tests and integration tests:

- `Unit tests`: The `BookServiceTest` class contains unit tests for the `BookService` layer, with `BookRepository` mocked using Mockito.
- `Integration tests`: The `BookControllerTest` class contains integration tests for the `BookController` layer, using `MockMvc` to send HTTP requests and assert the responses.

## Usage

To run the application, ensure you have a MySQL server running and configured correctly in the `application.properties` file. Then you can use the Spring Boot Maven plugin to run the application:

```
mvn spring-boot:run
```

This will start the application and it will be accessible at `http://localhost:8080`.

## AI Tools Demo

The project is designed to be used as a starting point for demonstrating various AI coding tools. Each tool can be used to assist with tasks such as filling out the classes, generating constructors, getters, setters, or methods in the service class, generating endpoints in the controller class, and creating unit and integration tests. The repository includes a series of pre-defined issues that can be tackled using the AI tools.

By working through these tasks, the strengths and weaknesses of each AI tool can be evaluated, providing a practical comparison of each tool's capabilities.

## Contribution

Feel free to clone the repository, create your own branches, and experiment with different AI tools. Your experiences and observations would be valuable to the broader community.
