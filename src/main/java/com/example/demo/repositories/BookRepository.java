package com.example.demo.repositories;

import com.example.demo.domain.Book;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book,String> {

    Optional<Book> findByIsbn(String isbn);

    void deleteByIsbn(String isbn);

    List<Book> findAllBy(TextCriteria criteria);

    @Query("{$or: [{'publisher.name': {$regex: ?0}}, {'publisher.url': {$regex: ?0}}, { 'author' : { $regex: ?0 }}, { 'title' : { $regex: ?0 }}, { 'subtitle' : { $regex: ?0 }}, { 'abstract' : { $regex: ?0 }} ] }")
    List<Book> findBooksByRegexp(String regexp);


}
