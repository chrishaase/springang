package com.example.demo.controller;

import com.example.demo.repositories.BookRepository;
import com.example.demo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
class BookController {

    @Autowired
    private BookRepository repo;

    @GetMapping("/books")
    @ResponseBody
    public List<Book> getAll(){
        return repo.findAll();
    }

    @GetMapping("/books/{id}")
    @ResponseBody
    public Book getByIsbn(@PathVariable("id") String id){
        Book.Publisher publisher = new Book.Publisher("", "");
        return repo.findByIsbn(id).orElse(new Book("", "", "", "", "", "", publisher));
    }

}
