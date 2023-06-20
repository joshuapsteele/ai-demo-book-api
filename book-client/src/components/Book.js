import React from 'react';

const Book = ({ book }) => {
    return (
        <tr>
            <td>{book.id}</td>
            <td>{book.title}</td>
            <td>{book.author}</td>
            <td>{book.yearPublished}</td>
        </tr>
    );
};

export default Book;
