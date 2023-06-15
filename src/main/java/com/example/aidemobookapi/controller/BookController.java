package com.example.aidemobookapi.controller;

import com.example.aidemobookapi.domain.Book;
import com.example.aidemobookapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:3000")  // React app is served from this origin
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping(params = "title")
    public ResponseEntity<Book> findBookByTitle(@RequestParam("title") String title) {
        Book book = bookService.findBookByTitle(title);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeBook(@PathVariable Long id) {
        bookService.removeBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
