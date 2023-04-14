package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.DTO.RequestDto.AddBookDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.GetAuthorIdDto;import com.example.LibraryManagementSystem.DTO.RequestDto.GetAuthorNameDto;import com.example.LibraryManagementSystem.DTO.ResponseDto.GetBookResponseDto;import java.util.List;

public interface BookService {
  public String addBook(AddBookDto addBookDto) throws Exception;
  public List<GetBookResponseDto> getAllBooks();
  public List<GetBookResponseDto> getAllBooksByAuthorId(GetAuthorIdDto getAuthorIdDto);
  public int getNumberOfBooksByAuthor(GetAuthorNameDto getAuthorNameDto);
}
