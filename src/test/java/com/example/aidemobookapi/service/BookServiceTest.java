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
        Book anotherSavedBook = bookService.addBook(book);

        assertEquals(book, savedBook);
        assertEquals(book, anotherSavedBook);
        verify(bookRepository, times(2)).save(book);
    }

    @Test
    public void testRemoveBook() {
        Long bookId = 1L;
        Long anotherBookId = 2L;

        doNothing().when(bookRepository).deleteById(bookId);

        bookService.removeBook(bookId);
        bookService.removeBook(anotherBookId);

        verify(bookRepository, times(1)).deleteById(bookId);
    }

    @Test
    public void testFindBookByTitle() {
        String title = "Test Book";
        String anotherTitle = "Another Test Book";
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor("Test Author");
        books.add(book);
        Book anotherBook = new Book();
        anotherBook.setTitle(anotherTitle);
        anotherBook.setAuthor("Another Test Author");
        books.add(anotherBook);

        when(bookRepository.findAll()).thenReturn(books);

        Book foundBook = bookService.findBookByTitle(title);
        Book anotherFoundBook = bookService.findBookByTitle(anotherTitle);

        assertEquals(book, foundBook);
        assertEquals(anotherBook, anotherFoundBook);
    }
}
