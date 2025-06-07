package com.ver.BookLib.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30)
    private String name;
    @Column(length=30,unique=true)
    private String email;
    @Column(length=30,unique=true)
    private String phoneNo;
    private String address;
    private String password;
    private String authority;

    @CreationTimestamp
    private Date CreatedOn;
    @UpdateTimestamp
    private Date UpdatedOn;

    @Enumerated(value=EnumType.STRING)
    private StudentType status;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Book> list;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Txn> txnList;

}
