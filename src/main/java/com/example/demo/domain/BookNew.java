package com.example.demo.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "books")
public class BookNew {


    private String _id;
    private String isbn;
    private String title;
    private String subtitle;
    private String numPages;
    private String author;
    private String cover;
    private String abstract1;
    private Book.Publisher publisher;
    private List<String> keywords;

    public BookNew(){}

    public BookNew(String _id, String abstract1, String isbn, String title, String subtitle, String numPages, String author,
                   String cover, Book.Publisher publisher, List<String> keywords){
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
        return _id;
    }

    public void set_id(String _id) {
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

    public Book.Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Book.Publisher publisher) {
        this.publisher = publisher;
    }


}




