package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.DTO.RequestDto.AddAuthorDto;
import com.example.LibraryManagementSystem.Entity.Author;

public interface AuthorService {
  public String addAuthor(AddAuthorDto addAuthorDto);
}
