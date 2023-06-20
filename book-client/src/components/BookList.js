import React, { useState, useEffect } from 'react';
import BookService from '../services/BookService';

const BookList = () => {
    const [books, setBooks] = useState([]);

    useEffect(() => {
        BookService.getAllBooks()
            .then(response => setBooks(response.data))
            .catch(error => console.error);
    }, []);

    return (
        <div>
            <ul>
                {books.map(book => (
                <li key={book.id}>
                    <h2>{book.title}</h2>
                    <p>{book.author}</p>
                    <p>{book.year_published}</p>
                </li>
                ))}
            </ul>
        </div>
    );
};

export default BookList;
