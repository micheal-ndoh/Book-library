# 📚 Library Management System

A simple Java web application to manage books using Servlets for the backend and plain HTML/JS for the frontend. You can view, add, and delete books via both the frontend interface and the terminal.

---

## ✅ Features

* Add and view books (title + author)
* Delete books from the list
* Frontend: user-friendly interface
* Backend: in-memory storage using Java Servlet

---

## 🚀 How to Run

### 1. **Backend (Java Servlet)**

> 📦 Make sure you have **Apache Tomcat** and **Java 8+** installed.

1. Import the project into any Java IDE (e.g., IntelliJ IDEA, vscode).
2. Run `mvn clean install`
3. Run `mvn tomcat7:run`
4. Deploy the project to Tomcat (e.g., `http://localhost:8080/library-app`).
5. Make sure the backend is accessible at:

   ```sh
   http://localhost:8080/library-app/books
   ```

---

### 2. **Frontend (HTML + JS)**

> 🌐 You can use **VS Code Live Server** or Python/Node to serve it.



** Using VS Code Live Server:**
```sh
cd src/frontend
npx http-server
```

**Using Python:**

```bash
cd src/frontend
python3 -m http.server 8081
```

Then open in browser:

```sh
http://127.0.0.1:8081/
```

---

## 📝 How to Add Books

### ➕ Using the Frontend

1. Go to `http://127.0.0.1:8081/`
2. Fill in the **title** and **author**
3. Click **"Add Book"**
4. Click **"View All Books"** to see the updated list
5. Click **"Delete Book"** to delete a book by ID

---

### ➕ Using Terminal (cURL)

```bash
curl -X POST http://localhost:8080/library-app/books \
  -d "title=The Lord of the Rings &author=Micheal Ndoh"
```

✅ You’ll see the book added in both frontend and API responses.

---

## 🔁 Delete a Book (Terminal)

```bash
curl -X DELETE "http://localhost:8080/library-app/books?id=1"
```
