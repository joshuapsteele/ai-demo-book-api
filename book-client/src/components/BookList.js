import React, {useEffect, useState} from 'react';
import BookService from '../services/BookService';
import Book from './Book';

const BookList = () => {
    const [books, setBooks] = useState([]);
    const [sortConfig, setSortConfig] = useState({key: null, direction: 'ascending'});

    useEffect(() => {
        BookService.getAllBooks()
            .then(response => {
                const uniqueBooks = response.data.filter((book, index, self) =>
                        index === self.findIndex((b) => (
                            b.title === book.title && b.author === book.author && b.yearPublished === book.yearPublished
                        ))
                );
                setBooks(uniqueBooks);
            })
            .catch(error => console.error);
    }, []);

    const sortBooks = (key) => {
        let direction = 'ascending';
        if (sortConfig.key === key && sortConfig.direction === 'ascending') {
            direction = 'descending';
        }

        setSortConfig({key, direction});
    };

    const sortedBooks = [...books].sort((a, b) => {
        if (a[sortConfig.key] < b[sortConfig.key]) {
            return sortConfig.direction === 'ascending' ? -1 : 1;
        }
        if (a[sortConfig.key] > b[sortConfig.key]) {
            return sortConfig.direction === 'ascending' ? 1 : -1;
        }
        return 0;
    });

    return (
        <div className="book-list">
            <table>
                <thead>
                <tr>
                    <th className="sortable" onClick={() => sortBooks('id')}>
                        ID {sortConfig.key === 'id' ? (sortConfig.direction === 'ascending' ? '▲' : '▼') : ''}
                    </th>
                    <th className="sortable" onClick={() => sortBooks('title')}>
                        Title {sortConfig.key === 'title' ? (sortConfig.direction === 'ascending' ? '▲' : '▼') : ''}
                    </th>
                    <th className="sortable" onClick={() => sortBooks('author')}>
                        Author {sortConfig.key === 'author' ? (sortConfig.direction === 'ascending' ? '▲' : '▼') : ''}
                    </th>
                    <th className="sortable" onClick={() => sortBooks('yearPublished')}>
                        Year
                        Published {sortConfig.key === 'yearPublished' ? (sortConfig.direction === 'ascending' ? '▲' : '▼') : ''}
                    </th>
                </tr>
                </thead>
                <tbody>
                {sortedBooks.map(book => (
                    <Book key={book.id} book={book}/>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default BookList;
