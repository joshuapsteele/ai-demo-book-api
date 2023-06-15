package com.example.aidemobookapi.service;

import com.example.aidemobookapi.domain.Book;
import com.example.aidemobookapi.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testAddBook() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");

        when(bookRepository.save(book)).thenReturn(book);

        Book savedBook = bookService.addBook(book);

        assertEquals(book, savedBook);
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    public void testRemoveBook() {
        Long bookId = 1L;

        doNothing().when(bookRepository).deleteById(bookId);

        bookService.removeBook(bookId);

        verify(bookRepository, times(1)).deleteById(bookId);
    }

    @Test
    public void testFindBookByTitle() {
        String title = "Test Book";
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor("Test Author");
        books.add(book);

        when(bookRepository.findAll()).thenReturn(books);

        Book foundBook = bookService.findBookByTitle(title);

        assertEquals(book, foundBook);
    }
}