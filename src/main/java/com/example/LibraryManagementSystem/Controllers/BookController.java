package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.DTO.RequestDto.AddBookDto;import com.example.LibraryManagementSystem.DTO.RequestDto.GetAuthorIdDto;import com.example.LibraryManagementSystem.DTO.RequestDto.GetAuthorNameDto;import com.example.LibraryManagementSystem.DTO.ResponseDto.GetBookResponseDto;import com.example.LibraryManagementSystem.Entity.Book;
import com.example.LibraryManagementSystem.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;import java.util.List;

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

    @GetMapping("/getAllBooks")
    public List<GetBookResponseDto> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    @GetMapping("/getAllBooksByAuthorId")
    public  List<GetBookResponseDto> getAllBooksByAuthorId(@RequestBody GetAuthorIdDto getAuthorIdDto)
    {
        return bookService.getAllBooksByAuthorId(getAuthorIdDto);
    }

    @GetMapping("/getNumberOfBooksByAuthor")
    public int getNumberOfBooksByAuthor(@RequestBody GetAuthorNameDto getAuthorNameDto )
    {
        return bookService.getNumberOfBooksByAuthor(getAuthorNameDto);
    }
}
