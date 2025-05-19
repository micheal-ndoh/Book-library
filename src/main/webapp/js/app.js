const API_URL = "http://127.0.0.1:8083/library-app/books";

// Fetch and display books
async function loadBooks() {
    const response = await fetch(API_URL);
    const books = await response.json();
    const bookList = document.getElementById('book-list');
    bookList.innerHTML = books.map(book => `
        <div class="book">
            <div class="book-info">
                <div class="book-title">${book.title}</div>
                <div class="book-author">by ${book.author}</div>
            </div>
            <button class="delete-btn" onclick="deleteBook(${book.id})">Delete</button>
        </div>
    `).join('');
}

// Add a new book
async function addBook() {
    const title = document.getElementById('title').value;
    const author = document.getElementById('author').value;

    if (!title.trim() || !author.trim()) {
        alert("Please fill in both Title and Author fields.");
        return;
    }

    await fetch(API_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: `title=${encodeURIComponent(title)}&author=${encodeURIComponent(author)}`
    });

    document.getElementById('title').value = '';
    document.getElementById('author').value = '';
    loadBooks();
}

// Delete a book
async function deleteBook(id) {
    await fetch(`${API_URL}?id=${id}`, {
        method: 'DELETE'
    });
    loadBooks();
}

// Initialize
loadBooks();