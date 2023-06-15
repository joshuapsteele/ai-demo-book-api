import React from 'react';
import BookList from './components/BookList';
import BookForm from './components/BookForm';

function App() {
  return (
    <div className="App">
      <h1>Book API Client</h1>
      <BookForm />
      <BookList />
    </div>
  );
}

export default App;
