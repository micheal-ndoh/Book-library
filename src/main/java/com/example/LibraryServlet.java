package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.db.LibraryDB;
import com.example.entities.Book;
import com.google.gson.Gson;

@WebServlet("/books")
public class LibraryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, OPTIONS"); // Allowed methods
        res.setHeader("Access-Control-Allow-Headers", "Content-Type"); // Allowed headers
        res.setContentType("application/json");
        
        PrintWriter out = res.getWriter();
        out.print(new Gson().toJson(LibraryDB.getAllBooks()));
    }  

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, OPTIONS");
        res.setHeader("Access-Control-Allow-Headers", "Content-Type");
        
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        LibraryDB.addBook(new Book(title, author));
        res.setStatus(HttpServletResponse.SC_CREATED); // 201
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, OPTIONS");
        res.setHeader("Access-Control-Allow-Headers", "Content-Type");
        
        int id = Integer.parseInt(req.getParameter("id"));
        LibraryDB.deleteBook(id);
        res.setStatus(HttpServletResponse.SC_NO_CONTENT); // 204
    }

    // Handle preflight requests
    protected void doOptions(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, OPTIONS");
        res.setHeader("Access-Control-Allow-Headers", "Content-Type");
        res.setStatus(HttpServletResponse.SC_OK); // 200
    }
}
