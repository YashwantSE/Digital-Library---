package com.ver.BookLib.controller;

import com.ver.BookLib.exception.TxnException;
import com.ver.BookLib.model.Student;
import com.ver.BookLib.request.TxnCreateRequest;
import com.ver.BookLib.request.TxnReturnRequest;
import com.ver.BookLib.response.GenericResponse;
import com.ver.BookLib.service.TxnService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/txn")
public class TxnController {
    @Autowired
    private TxnService txnService;
    private TxnCreateRequest txnCreateRequest;

    @PostMapping("/create")
    public ResponseEntity<GenericResponse<String>> createTxn(@RequestBody @Valid TxnCreateRequest txnCreateRequest) throws TxnException {
        this.txnCreateRequest = txnCreateRequest;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Student student =  (Student) authentication.getPrincipal();

        String txnid =  txnService.create(txnCreateRequest, student);

        GenericResponse<String> response  = new GenericResponse<>(txnid, "", "success", "200");

        ResponseEntity entity = new ResponseEntity<>(response, HttpStatus.OK);
        return entity;
    }

    @PutMapping("/return")
    public int returnTxn(@RequestBody TxnReturnRequest txnReturnRequest) throws TxnException {
        return txnService.returnBook(txnReturnRequest);
    }
}
