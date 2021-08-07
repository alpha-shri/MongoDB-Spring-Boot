package com.app.dao;

import com.app.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {

    @Query("{'bookName': ?0}")
    Optional<Book> findByBookName(String bookName);


    @Query("{'category': ?0}")
    Optional<Book> findByCategory(String category);
}
