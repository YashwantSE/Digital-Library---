package com.ver.BookLib.controller;

import com.ver.BookLib.exception.TxnException;
import com.ver.BookLib.model.Student;
import com.ver.BookLib.request.StudentCreateRequest;
import com.ver.BookLib.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    public Student createAdmin(@RequestBody StudentCreateRequest studentCreateRequest) throws TxnException {

     //validation
        if(StringUtils.isEmpty(studentCreateRequest.getPhoneNo())){
            throw new TxnException("student phone no can not be null");
        }
        return adminService.createAdmin(studentCreateRequest);
    }
}
