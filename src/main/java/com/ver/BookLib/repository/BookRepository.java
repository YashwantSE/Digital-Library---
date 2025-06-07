package com.ver.BookLib.repository;

import com.ver.BookLib.model.Book;
import com.ver.BookLib.model.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
     //  default methods
    //--> findAllbyId
    //-->findById
    //-->findAll

    //Jpa query methods on docs.spring.io / custom finder methods
    List<Book> findByBookNo(String bookNo);

    List<Book> findByAuthorName(String authorName);
    List<Book> findByCost(int cost);

    List<Book> findByType(BookType bookType);
    List<Book> findByCostLessThan(int cost);
}



