package com.example.demo.service;

import com.example.demo.persistence.model.Book;
import org.springframework.data.mongodb.core.query.TextCriteria;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> findByIsbn(String isbn);

    void deleteByIsbn(String isbn);

    List<Book> findAllBy(TextCriteria criteria);

    List<Book> findBooksByRegexp(String regexp);

    List<Book> findAll();

    void save(Book book);

    Book findById(String id);

}
