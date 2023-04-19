package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.DTO.RequestDto.IssueBookDto;import com.example.LibraryManagementSystem.DTO.ResponseDto.IsssueBookResponseDto;public interface TransactionService
{
    public IsssueBookResponseDto issueBook(IssueBookDto issueBookDto) throws Exception;
}
