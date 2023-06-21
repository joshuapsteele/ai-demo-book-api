import requests
import json

# Define the API endpoint
url = 'http://localhost:8080/api/books'

# Define the headers for the API request
headers = {
    'Content-Type': 'application/json'
}

# Define the Google Books API URL
google_books_url = 'https://www.googleapis.com/books/v1/volumes'

# Define your Google Books API key
API_KEY = 'AIzaSyAsS_ntn-ohG_9xFXrg8j_cyZ7OWU5pokM'

# Define the parameters for the API request
params = {
    'q': 'book',  # Get books with a title
    'maxResults': 25,  # Get 50 results
    'key': API_KEY  # Your Google Books API key
}

# Send a GET request to the Google Books API
response = requests.get(google_books_url, params=params)

# If the request was successful
if response.status_code == 200:
    # Get the JSON data from the response
    data = response.json()

    # Loop through each book in the data
    for book in data['items']:
        # Get the book details
        title = book['volumeInfo'].get('title', 'N/A')
        authors = book['volumeInfo'].get('authors', ['N/A'])
        publishedDate = book['volumeInfo'].get('publishedDate', 'N/A')

         # Extract just the year from the publishedDate
        yearPublished = None if publishedDate == 'N/A' else publishedDate.split('-')[0]

        # Create a new book object
        new_book = {
            'title': title,
            'author': ', '.join(authors),
            'yearPublished': yearPublished
        }

        # Send a POST request to your API to add the new book
        response = requests.post(url, headers=headers, data=json.dumps(new_book))

        # If the request was successful
        if response.status_code == 200:
            print(f"Book '{new_book['title']}' added successfully.")
        else:
            print(f"Failed to add book '{new_book['title']}'. Server responded with: {response.status_code}.")
else:
    print(f"Failed to get books from Google Books API. Server responded with: {response.status_code}.")
