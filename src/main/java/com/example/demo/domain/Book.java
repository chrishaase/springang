package com.example.demo.domain;

import java.time.LocalDate;
import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book {


    @Id
    private ObjectId _id;
    private String isbn;
    private String title;
    private String subtitle;
    private String numPages;
    private String author;
    private String cover;

    private Publisher publisher;

    public Book(String isbn, String title, String subtitle, String numPages, String author, String cover, Publisher publisher){
        this.author = author;
        this.isbn = isbn;
        this.title = title;
        this.subtitle = subtitle;
        this.numPages = numPages;
        this.cover = cover;
        this.publisher = publisher;


    }


    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }
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
        public String name;
        public String url;

        public Publisher( String name, String url ) {
            this.name = name;
            this.url = url;
        }

    }
}




