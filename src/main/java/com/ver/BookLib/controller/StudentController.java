package com.ver.BookLib.controller;


import com.ver.BookLib.exception.TxnException;
import com.ver.BookLib.model.Student;
import com.ver.BookLib.request.StudentCreateRequest;
import com.ver.BookLib.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    public Student createStudent(@RequestBody StudentCreateRequest studentCreateRequest)throws TxnException {

        //validation
        if(StringUtils.isEmpty(studentCreateRequest.getPhoneNo())){
            throw new TxnException("student phone no can not be null.");
        }
        return studentService.createStudent(studentCreateRequest);
    }
}
