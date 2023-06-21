package com.example.aidemobookapi.service;

import com.example.aidemobookapi.domain.Book;
import com.example.aidemobookapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        // Check if the book already exists. If it does, then do not save the book to the database and return the book that already exists.
        return bookRepository.save(book);
    }

    public void removeBook(Long id) {
        // Here you might want to add some business logic like checking if the book exists before deleting
        bookRepository.deleteById(id);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookByTitle(String title) {
        // Here you might want to add some business logic like what to do if there are multiple books with the same title
        // For now we just return the first match
        Optional<Book> book = bookRepository.findAll().stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst();

        if (book.isPresent()) {
            return book.get();
        } else {
            // You might want to handle this situation differently, for example by throwing an exception
            return null;
        }
    }
}
