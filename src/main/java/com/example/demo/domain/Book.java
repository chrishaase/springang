package com.example.demo.domain;

import java.time.LocalDate;
import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "books")
public class Book {


    @Id
    private ObjectId _id;
    @TextIndexed
    private String isbn;
    @TextIndexed
    private String title;
    @TextIndexed
    private String subtitle;
    private String numPages;
    @TextIndexed
    private String author;
    private String cover;
    @Field("abstract")
    @TextIndexed
    private String abstract1;
    @TextIndexed
    private Publisher publisher;
    private List<String> keywords;

    public Book(){}

    public Book(ObjectId _id, String abstract1, String isbn, String title, String subtitle, String numPages, String author, String cover, Publisher publisher, List<String> keywords){
        this._id = _id;
        this.author = author;
        this.isbn = isbn;
        this.title = title;
        this.subtitle = subtitle;
        this.numPages = numPages;
        this.cover = cover;
        this.publisher = publisher;
        this.abstract1 = abstract1;
        this.keywords = keywords;


    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getAbstract1() {
        return abstract1;
    }

    public void setAbstract1(String abstract1) {
        this.abstract1 = abstract1;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getNumPages() {
        return numPages;
    }

    public void setNumPages(String numPages) {
        this.numPages = numPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public static class Publisher {
        @TextIndexed
        public String name;
        @TextIndexed
        public String url;

        public Publisher( String name, String url ) {
            this.name = name;
            this.url = url;
        }

    }
}




