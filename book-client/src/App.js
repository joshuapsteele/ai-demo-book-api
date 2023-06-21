import React from 'react';
import './App.css';
import BookList from './components/BookList';
import BookForm from './components/BookForm';

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <h1>Book Library</h1>
            </header>
            <main>
                <h2>Add a book</h2>
                <BookForm/>
                <h2>Book List</h2>
                <BookList/>
            </main>
        </div>
    );
}

export default App;
