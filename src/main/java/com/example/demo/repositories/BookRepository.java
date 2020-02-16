package com.example.demo.repositories;

import com.example.demo.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book,String> {

    Optional<Book> findByIsbn(String isbn);
}
