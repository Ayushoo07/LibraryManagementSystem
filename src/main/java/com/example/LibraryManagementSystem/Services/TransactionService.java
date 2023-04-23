package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.DTO.RequestDto.IssueBookDto;import com.example.LibraryManagementSystem.DTO.RequestDto.ReturnBookDto;import com.example.LibraryManagementSystem.DTO.ResponseDto.IsssueBookResponseDto;
import com.example.LibraryManagementSystem.DTO.ResponseDto.ReturnBookResponse;

public interface TransactionService {
    public IsssueBookResponseDto issueBook(IssueBookDto issueBookDto) throws Exception;

  public ReturnBookResponse returnBook(ReturnBookDto returnBookDto) throws Exception;
}
