import React, { useState, useEffect } from 'react';
import Book from './Book';

const BookList = () => {
    const [books, setBooks] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8888/books')
            .then(response => response.json())
            .then(data => setBooks(data))
            .catch(error => console.error);
    }, []);

    return (
        <div>
            {books.map(book => (
                <Book key={book.id} book={book} />
            ))}
        </div>
    );
};

export default BookList;
