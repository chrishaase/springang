package com.example.demo.controller;

import com.example.demo.domain.BookNew;
import com.example.demo.repositories.BookRepository;
import com.example.demo.domain.Book;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        System.out.println(repo.findAll());
        return repo.findAll();
    }

    @GetMapping("/books/{id}")
    @ResponseBody
    public Book getByIsbn(@PathVariable("id") String id){
        return repo.findByIsbn(id).get();
    }

    @PostMapping("/books")
    public void addBook(@RequestBody BookNew bookNew) {
        // check if book has valid Id - if not add one
        // probably needs bookDTO

        Book book = new Book(ObjectId.get(), bookNew.getAbstract1(), bookNew.getIsbn(), bookNew.getTitle(),
                bookNew.getSubtitle(), bookNew.getNumPages(), bookNew.getAuthor(), bookNew.getCover(), bookNew.getPublisher());

        System.out.println(book.get_id());
        repo.save(book);
    }

    @PutMapping("/books")
    public void updateBook(@RequestBody Book book) {
       repo.save(book);

    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable("id") String id){
        repo.deleteByIsbn(id);
    }


}
