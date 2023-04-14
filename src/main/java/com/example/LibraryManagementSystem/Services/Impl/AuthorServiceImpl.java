package com.example.LibraryManagementSystem.Services.Impl;

import com.example.LibraryManagementSystem.DTO.RequestDto.AddAuthorDto;
import com.example.LibraryManagementSystem.Entity.Author;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import com.example.LibraryManagementSystem.Services.AuthorService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    AuthorRepository authorRepository;

  @Override
  public String addAuthor(AddAuthorDto addAuthorDto)
  {
      Author author = new Author();
      author.setName(addAuthorDto.getName());
      author.setAge(addAuthorDto.getAge());
      author.setEmail(addAuthorDto.getEmail());

      authorRepository.save(author);
    return "Author added Successfully";
  }
}
