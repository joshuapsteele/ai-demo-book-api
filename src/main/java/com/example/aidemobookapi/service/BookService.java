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
        return bookRepository.save(book);
    }

    public void removeBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookByTitle(String title) {
        Optional<Book> book = bookRepository.findAll().stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst();

        if (book.isPresent()) {
            return book.get();
        } else {
            return null;
        }
    }
}
