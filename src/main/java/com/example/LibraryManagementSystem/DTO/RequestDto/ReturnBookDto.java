package com.example.LibraryManagementSystem.DTO.RequestDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReturnBookDto
{
    private int cardId;
    private int bookId;
    private String issueBookNo;
}
