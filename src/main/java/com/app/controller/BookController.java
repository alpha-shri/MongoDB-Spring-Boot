package com.app.controller;


import com.app.entities.Book;
import com.app.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;



    @PostMapping("/add")
    public ResponseEntity saveBook(@RequestBody Book newBook){
        Book book = service.saveBookService(newBook);

        return ResponseEntity.ok(book);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Book> fetchBookById(@PathVariable int id){
        Book book = service.fetchBookByIdService(id);
        return new ResponseEntity(book, HttpStatus.OK);
    }

    @GetMapping("/findbycategory/{category}")
    public ResponseEntity<Book> fetchBookByName(@PathVariable String category){
        Book book = service.fetchBookByCategoryService(category);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){

        List<Book> bookList = service.findAllService();
        return new ResponseEntity(bookList, HttpStatus.OK);

    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity deleteById(@PathVariable int id){
        String status = service.deleteByIdService(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


}
