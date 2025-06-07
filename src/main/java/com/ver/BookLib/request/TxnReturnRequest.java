package com.ver.BookLib.request;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TxnReturnRequest {

    private String studentContact;
    private String bookNo;
    private String txnId;

}
