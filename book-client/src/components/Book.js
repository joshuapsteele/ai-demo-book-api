import React from 'react';

const Book = ({ book }) => (
    <li>
        <h2>{book.title}</h2>
        <p>{book.author}</p>
        <p>{book.year_published}</p>
    </li>
);

export default Book;
