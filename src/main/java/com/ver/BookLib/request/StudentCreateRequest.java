package com.ver.BookLib.request;


import com.ver.BookLib.model.Student;
import com.ver.BookLib.model.StudentType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCreateRequest {
    private String name;
    private String phoneNo;
    private String email;
    private String address;
    private String password;
    private String authority;


    public Student toStudent(){
        return Student.builder().
                name(this.name).
                phoneNo(this.phoneNo)
                .email(this.email)
                .address(this.address)
                .password(this.password)
                .authority(this.authority)
                .status(StudentType.ACTIVE)
                .build();
    }
}
