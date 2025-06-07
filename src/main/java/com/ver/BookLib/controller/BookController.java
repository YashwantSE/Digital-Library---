package com.ver.BookLib.controller;


import com.ver.BookLib.model.Book;
import com.ver.BookLib.model.FilterType;

import com.ver.BookLib.model.Operator;
import com.ver.BookLib.request.BookCreateRequest;
import com.ver.BookLib.response.GenericResponse;
import com.ver.BookLib.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public Book createBook(@RequestBody @Valid BookCreateRequest bookCreateRequest){
    //validation can here
    return bookService.createBook(bookCreateRequest);
    }

    @GetMapping("/filter")
    public ResponseEntity<GenericResponse<List<Book>>> filter(@RequestParam("filterBy") FilterType filterBy,
    @RequestParam("operator")Operator operator, @RequestParam("value") String value){
      List<Book> list = bookService.filter(filterBy,operator,value);
      GenericResponse<List<Book>> response =new GenericResponse<> (list,"","success","200");
      return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
