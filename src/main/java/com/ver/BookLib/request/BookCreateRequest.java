package com.ver.BookLib.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.ver.BookLib.model.Author;
import com.ver.BookLib.model.Book;
import com.ver.BookLib.model.BookType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateRequest {
    @NotNull(message = "Book name cannot be blank")
    private String name;
    @NotNull(message= "book No cannot be blank")
    private String bookNo;
    @Positive(message="it must be positive")
    private int cost;
    private BookType type;
    private String authorName;
    private String authorEmail;

      public Author toAuthor() {
          return Author.builder()
                  .name(this.authorName)
                  .email(this.authorEmail).
                  build();
      }

      public Book toBook(){
          return Book.builder().
                  name(this.name).
                  bookNo(this.bookNo).
                  cost(this.cost).
                  type(this.type).
                  build();
      }

}
