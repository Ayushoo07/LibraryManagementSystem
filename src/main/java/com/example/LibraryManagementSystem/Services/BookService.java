package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.DTO.RequestDto.AddBookDto;
import com.example.LibraryManagementSystem.Entity.Book;

public interface BookService {
  public String addBook(AddBookDto addBookDto) throws Exception;
}
