# AI Coding Tool Demo - Book API

## Context

This repo provides sketched-out "Book API" starting points to fill-out using GitHub Copilot, AWS Codewhisperer, Tabnine, and Codeium for the purposes of a comparative pilot test.

The "Book API" idea was generated with the help of ChatGPT-4 with the Bing plugin enabled.

### Original Prompt to ChatGPT-4 (with Bing plugin enabled)

I'm running a pilot demo/test of AI coding tools (GitHub Copilot, AWS Codewhisperer, Tabnine, and Codeium) in VS Code, programming in Java. I need a "test"/"standard" Java program in which to use each tool. Can you help me write a Java program for this purpose? 

### ChatGPT-4 Answer

Absolutely, I'd be happy to help with that! Here's a basic idea: we can design a simple console application where you manage a collection of books. This will involve classes, inheritance, encapsulation, and some basic data structures which are common elements in many Java programs. We can also include some methods that involve common algorithms, such as sorting or searching. Here's a rough outline of the program:

```java
import java.util.*;

class Book {
    private String title;
    private String author;
    private int yearPublished;

    // Constructor, getters and setters
    // ...
}

class BookCollection {
    private List<Book> books;

    public BookCollection() {
        books = new ArrayList<>();
    }

    // Method to add a book
    // Method to remove a book
    // Method to find a book by title
    // Method to sort books by year published
    // ...
}

public class Main {
    public static void main(String[] args) {
        // Create some books and add them to the collection
        // Print out the books in the collection
        // Sort the books and print them out again
        // Find a book by title
        // ...
    }
}
```

You can then use the AI coding tools to help you implement the missing parts of this program, such as the constructors, getters and setters, and the methods in the `BookCollection` class. This should give you a good idea of the strengths and weaknesses of each tool. For example, how well can they generate the boilerplate code for the `Book` class? Can they generate a correct and efficient sorting method in the `BookCollection` class? Can they understand the context well enough to generate a correct method for finding a book by title?

The final program would be a good test case, as it includes a variety of different types of code that you might want to generate using these tools. 

Let me know if you need help filling out the rest of the code.

### Follow-up Prompt

I like the Book-related program idea. Can you help me write this as a Java Spring Boot application? I'd like to be able to include unit tests and integration tests as well.

### Follow-up Answer from ChatGPT-4

Sure, I can definitely help with that. We can create a Spring Boot application with a RESTful API that allows us to manage the books. This will provide a broader range of functionality to test with your AI coding tools, and it will also allow us to write unit tests and integration tests.

Let's start by setting up the structure of the project:

1. **The Domain Model**: This will include our `Book` class.

```java
package com.example.demo.domain;

public class Book {
    private String id;
    private String title;
    private String author;
    private int yearPublished;

    // Constructor, getters and setters
}
```

2. **The Repository**: This will be an interface that extends `JpaRepository` for the `Book` entity.

```java
package com.example.demo.repository;

import com.example.demo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
```

3. **The Service**: This will be a service layer that uses the `BookRepository` to perform operations.

```java
package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Methods to add, remove, find, and sort books
}
```

4. **The Controller**: This will be a REST controller that exposes endpoints to manage the books.

```java
package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Endpoints to add, remove, find, and sort books
}
```

You can use your AI coding tools to help fill out these classes. For example, they might be able to help generate the constructors, getters and setters for the `Book` class, the methods in the `BookService` class, or the endpoints in the `BookController` class.

Next, you would create unit tests and integration tests:

1. **Unit tests**: You can create unit tests for your service layer. You can mock the `BookRepository` using a tool like Mockito, and then test the methods in the `BookService`.

2. **Integration tests**: You can create integration tests for your controller layer. You can use the `MockMvc` class from Spring Test to send HTTP requests to your controller and assert the responses.

Again, you can use your AI coding tools to help generate these tests. They might be able to help generate the setup code for the tests, the mocks, or the assertions.

Remember to include your database configuration in `application.properties` file.

Let me know if you need help with specific parts of this application.
