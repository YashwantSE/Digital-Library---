package com.ver.BookLib.service;

import com.ver.BookLib.model.FilterType;
import com.ver.BookLib.model.Operator;
import com.ver.BookLib.model.Student;
import com.ver.BookLib.model.StudentFilterType;
import com.ver.BookLib.repository.StudentRepository;
import com.ver.BookLib.request.StudentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;

    @Value("${admin.authority}")
    private String adminAuthority;

    public Student createStudent(StudentCreateRequest studentCreateRequest){
        List<Student> studentList=studentRepository.findByPhoneNo(studentCreateRequest.getPhoneNo());
        Student studentFromDB=null;
        if(studentList==null||studentList.isEmpty()){
            studentCreateRequest.setAuthority(adminAuthority);
            studentFromDB=studentRepository.save(studentCreateRequest.toStudent());
            return studentFromDB;
        }
        studentFromDB=studentList.get(0);
        return studentFromDB;
    }

    public List<Student> filter(StudentFilterType filterBy, Operator operator, String value){
         switch(operator){
             case EQUALS :
                 switch(filterBy){
                     case CONTACT :
                         return studentRepository.findByPhoneNo(value);
                 }
             default:
                 return new ArrayList<>();
         }

    }

}
