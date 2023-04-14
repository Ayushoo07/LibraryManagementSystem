package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.DTO.RequestDto.AddAuthorDto;import com.example.LibraryManagementSystem.Entity.Author;
import com.example.LibraryManagementSystem.Services.AuthorService;
import com.example.LibraryManagementSystem.Services.Impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController
{
    @Autowired
    AuthorService authorService;

  @PostMapping("/add")
  public String addAuthor(@RequestBody AddAuthorDto addAuthorDto) {
        return authorService.addAuthor(addAuthorDto);
    }

    // delete a student by id

    // update the student by id

    // find a student by id

    // find all the students
}
