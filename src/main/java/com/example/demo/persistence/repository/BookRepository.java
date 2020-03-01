package com.example.demo.persistence.repository;

import com.example.demo.persistence.model.Book;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book,String> {

    Optional<Book> findByIsbn(String isbn);

    void deleteByIsbn(String isbn);

    List<Book> findAllBy(TextCriteria criteria);

    @Query("{$or: [{'publisher.name': {$regex: ?0, $options: 'i'}}, {'publisher.url': {$regex: ?0, $options: 'i'}}, { 'author' : { $regex: ?0, $options: 'i' }}, " +
            "{ 'title' : { $regex: ?0, $options: 'i'}}, { 'subtitle' : { $regex: ?0, $options: 'i' }}, { 'abstract' : { $regex: ?0, $options: 'i' }} ] }")
    List<Book> findBooksByRegexp(String regexp);


}
