package com.example.demo.web;

import com.example.demo.persistence.model.Book;
import com.example.demo.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// restcontroller includes controller and responseBocy for each method
@RestController
@RequestMapping("/api")
class BookController {

    private BookService bookService;
    private ModelMapper modelMapper;

    @Autowired
    public BookController(BookService bookService, ModelMapper modelMapper){
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/books")
    public List<BookDto> getAll(){
        Iterable<Book> books = bookService.findAll();
        List<BookDto> list = new ArrayList<>();
        books.forEach(p -> list.add(convertToDto(p)));
        return list;
    }

    @GetMapping("/books/{id}")
    public BookDto getByIsbn(@PathVariable("id") String id){
        return convertToDto(bookService.findByIsbn(id).get());
    }

    @PostMapping("/books")
    public void addBook(@RequestBody BookDto bookDto) {

        bookService.save(convertToEntity(bookDto));
    }

    @PutMapping("/books")
    public void updateBook(@RequestBody BookDto bookDto) {
        // implemente dto logic here
       bookService.save(convertToEntity(bookDto));

    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable("id") String id){

        bookService.deleteByIsbn(id);
    }

    @GetMapping("/books/fulltext/{term}")
    public List<BookDto> findBooks(@PathVariable("term") String term){
        TextCriteria search = TextCriteria.forDefaultLanguage().matching(term);
        Iterable<Book> books = bookService.findAllBy(search);
        List<BookDto> list = new ArrayList<>();
        books.forEach(p -> list.add(convertToDto(p)));
        return list;
    }

    @GetMapping("/books/regex")
    public List<BookDto> findBookByRegexp(@RequestParam(value="term", defaultValue = " ") String term){

        Iterable<Book> books = bookService.findBooksByRegexp(term);
        List<BookDto> list = new ArrayList<>();
        books.forEach(p -> list.add(convertToDto(p)));
        return list;

    }

    private BookDto convertToDto(Book book){
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        return bookDto;
    }

    private Book convertToEntity(BookDto bookDto){
        Book book = modelMapper.map(bookDto, Book.class);

            // book is new - also check ob eines mit selber isbn schon da
            if(bookService.findByIsbn(book.getIsbn()).isPresent()){
                Book oldbook = bookService.findByIsbn(bookDto.getIsbn()).get();
                book.set_id(oldbook.get_id_Obj());
                System.out.println("check " + book.get_id());
            }
            // Do something if it has the same isbn treat as update

        return book;
    }


}
