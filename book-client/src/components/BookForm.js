import React, { useState } from 'react';
import BookService from '../services/BookService';

function BookForm() {
    const [title, setTitle] = useState('');
    const [author, setAuthor] = useState('');
    const [yearPublished, setYearPublished] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();

        const book = {
            title,
            author,
            yearPublished,
        };

        try {
            await BookService.addBook(book);
            setTitle('');
            setAuthor('');
            setYearPublished('');
            alert('Book added successfully!');
        } catch (error) {
            alert('An error occurred while adding the book.');
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <label>
                Title:
                <input type="text" value={title} onChange={e => setTitle(e.target.value)} required />
            </label>
            <label>
                Author:
                <input type="text" value={author} onChange={e => setAuthor(e.target.value)} required />
            </label>
            <label>
                Year Published:
                <input type="number" value={yearPublished} onChange={e => setYearPublished(e.target.value)} required />
            </label>
            <button type="submit">Add Book</button>
        </form>
    );
}

export default BookForm;
