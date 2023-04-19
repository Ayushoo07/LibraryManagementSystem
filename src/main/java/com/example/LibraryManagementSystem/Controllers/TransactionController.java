package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.DTO.RequestDto.IssueBookDto;import com.example.LibraryManagementSystem.DTO.ResponseDto.IsssueBookResponseDto;import com.example.LibraryManagementSystem.Services.TransactionService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transaction")
public class TransactionController
{
    @Autowired
    TransactionService transactionService;

    @PostMapping("/issuebook")
    public IsssueBookResponseDto issueBook(IssueBookDto issueBookDto)throws Exception
    {
        return transactionService.issueBook(issueBookDto);

    }
}
