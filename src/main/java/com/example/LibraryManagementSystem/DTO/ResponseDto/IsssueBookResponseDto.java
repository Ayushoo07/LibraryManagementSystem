package com.example.LibraryManagementSystem.DTO.ResponseDto;

import com.example.LibraryManagementSystem.Enums.TransactionStatus;import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IsssueBookResponseDto {
    private String issueBookNo;

    private String bookName;

    private TransactionStatus transactionStatus;
}
