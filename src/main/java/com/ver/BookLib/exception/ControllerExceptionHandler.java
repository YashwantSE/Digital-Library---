package com.ver.BookLib.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = TxnException.class)
    public ResponseEntity<Object> handle(TxnException txnException){
        return new ResponseEntity<>(txnException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handle(MethodArgumentNotValidException e){
        return new ResponseEntity<>(e.getBindingResult().getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);
    }
}
/**(e.getBindingResult().getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);
 * This line is used to extract validation error messages from a MethodArgumentNotValidException in Spring Boot (which is thrown when a @Valid or @Validated bean fails validation).
 e.getBindingResult()
 BindingResult is an object that holds all validation errors.

 This method returns an object that contains:

 Which fields failed

 What messages were generated

 The rejected values, etc.



 .getFieldError()
 Returns the first field error (if any) from the BindingResult.

 A field error contains info about which field failed and why.

 .getDefaultMessage()
 From the FieldError, this method returns the human-readable error message.

 This is usually the message you set in the validation annotation.
 */