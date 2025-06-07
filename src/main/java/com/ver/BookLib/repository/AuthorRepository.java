package com.ver.BookLib.repository;

import com.ver.BookLib.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends JpaRepository<Author, Integer> {


@Query("select a from Author a where a.email =:email")
Author getAuthorWithoutNative(String email);

    @Query("SELECT a FROM Author a WHERE a.email = :email")
    Author getAuthor(@Param("email") String email);

Author findByEmail(String email);
}
