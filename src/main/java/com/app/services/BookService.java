package com.app.services;

import com.app.dao.BookRepository;
import com.app.entities.Book;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

// Constructor-Injection
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    public Book saveBookService(Book newBook) {
        return bookRepository.save(newBook);
    }

    public Book fetchBookByIdService(int id) {

        return bookRepository.findById(id)
                             .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));

    }

    public List<Book> findAllService() {
        return bookRepository.findAll();
    }

    public String deleteByIdService(int id) {
        String status = "FAILED";

        try {
            bookRepository.deleteById(id);
            status = "SUCCESS";
        }catch (RuntimeException ex){
            ex.printStackTrace();
            ex.getMessage();

        }
        return status;
    }

    public Book fetchBookByCategoryService(String category){
        return bookRepository.findByCategory(category)
                             .orElseThrow( () -> new RuntimeException("No book found with category: " +category));
    }
}
