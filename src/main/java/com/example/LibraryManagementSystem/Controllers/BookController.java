package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.DTO.RequestDto.AddBookDto;import com.example.LibraryManagementSystem.Entity.Book;
import com.example.LibraryManagementSystem.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController
{
    @Autowired
    BookService bookService;

  @PostMapping("/add")
  public String addBook(@RequestBody AddBookDto addBookDto) throws Exception {

        return bookService.addBook(addBookDto);
    }

    // find all the books

    // find all the books of a particular authorId

    // // find the number of books written by an autho
}
