package com.ver.BookLib.service;

import com.ver.BookLib.model.*;
import com.ver.BookLib.model.Author;
import com.ver.BookLib.model.Book;
import com.ver.BookLib.model.Operator;
import com.ver.BookLib.repository.AuthorRepository;
import com.ver.BookLib.repository.BookRepository;
import com.ver.BookLib.request.BookCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import static com.ver.BookLib.model.FilterType.BOOK_NO;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public AuthorRepository authorRepository;

    public Book createBook(BookCreateRequest bookCreateRequest) {
        Author authorFromDb = authorRepository.findByEmail(bookCreateRequest.getAuthorEmail());
        if (authorFromDb == null) {
            // create a row inside the author table
            authorFromDb = authorRepository.save(bookCreateRequest.toAuthor());
        }
        Book book = bookCreateRequest.toBook();
        book.setAuthor(authorFromDb);
        book = bookRepository.save(book);
        return book;
    }

    public List<Book> filter(FilterType filterBy, Operator operator, String value){
     switch(operator){
         case EQUALS:
             switch(filterBy){
                 case BOOK_NO:
                    List<Book> list = bookRepository.findByBookNo(value);
                     return list;
                 case AUTHOR_NAME:
                     return bookRepository.findByAuthorName(value);
                 case COST:
                     return bookRepository.findByCost(Integer.valueOf(value));
                 case BOOKTYPE:
                     return bookRepository.findByType(BookType.valueOf(value));
             }
         case LESS_THAN:
             switch(filterBy){
                 case COST:
                     return bookRepository.findByCostLessThan(Integer.valueOf(value));
             }
         default:
              return new ArrayList<>();
     }
    }
    public void saveUpdate(Book book){
        bookRepository.save(book);
    }
}