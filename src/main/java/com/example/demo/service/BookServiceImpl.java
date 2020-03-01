package com.example.demo.service;

import com.example.demo.persistence.model.Book;
import com.example.demo.persistence.repository.BookRepository;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    public Optional<Book> findByIsbn(String isbn){
        return repository.findByIsbn(isbn);
    }

    public void deleteByIsbn(String isbn){
        repository.deleteByIsbn(isbn);
    }

    public List<Book> findAllBy(TextCriteria criteria){
        return repository.findAllBy(criteria);
    }

    public List<Book> findBooksByRegexp(String regexp) {
        return repository.findBooksByRegexp(regexp);
    }

    public List<Book> findAll(){
        return repository.findAll();
    }

    public void save(Book book){
        repository.save(book);
    }

    public Book findById(String id){
        return this.repository.findById(id).get();
    }
}
