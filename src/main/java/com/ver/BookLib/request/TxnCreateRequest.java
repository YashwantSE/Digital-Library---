package com.ver.BookLib.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TxnCreateRequest {

    @NotBlank(message = "Book No should not be blank")
    private String bookNo;
    @Positive(message=" Amount should be positive")
    private Integer amount;


}
