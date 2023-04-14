package com.example.LibraryManagementSystem.Services.Impl;

import com.example.LibraryManagementSystem.DTO.RequestDto.AddBookDto;import com.example.LibraryManagementSystem.DTO.RequestDto.GetAuthorIdDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.GetAuthorNameDto;
import com.example.LibraryManagementSystem.DTO.ResponseDto.GetBookResponseDto;
import com.example.LibraryManagementSystem.Entity.Author;import com.example.LibraryManagementSystem.Entity.Book;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import com.example.LibraryManagementSystem.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import java.util.ArrayList;import java.util.List;

@Service
public class BookServiceImpl implements BookService {
  @Autowired
  AuthorRepository authorRepository;

    @Override
  public String addBook(AddBookDto addBookDto) throws Exception {

        Book book = new Book();
        book.setGenre(addBookDto.getGenre());
        book.setPrice(addBookDto.getPrice());
        book.setNumberOfPages(addBookDto.getNumberOfPages());
        book.setTitle(addBookDto.getTitle());

        Author author;


        try {
      author = authorRepository.findById(addBookDto.getAuthorId()).get();
        }
        catch (Exception e)
        {
            throw new Exception("Author not found");
        }
        author.getBooks().add(book);

        book.setAuthor(author);

        authorRepository.save(author);


        return "Book added Succesfully";

  }

  @Override public List<GetBookResponseDto> getAllBooks() {
        List<GetBookResponseDto> res=new ArrayList<>();

        List<Author> authors = authorRepository.findAll();

        for (Author author: authors) {
            for (Book book:author.getBooks())
            {
                GetBookResponseDto getBookResponseDto=new GetBookResponseDto();
                getBookResponseDto.setTitle(book.getTitle());
                getBookResponseDto.setGenre(book.getGenre());
                getBookResponseDto.setPrice(book.getPrice());
                getBookResponseDto.setNumberOfPages(book.getNumberOfPages());
                getBookResponseDto.setId(book.getId());

                res.add(getBookResponseDto);
            }
        }

        return res;
    }

  @Override
  public List<GetBookResponseDto> getAllBooksByAuthorId(GetAuthorIdDto getAuthorIdDto) {
      List<GetBookResponseDto> res=new ArrayList<>();

      Author author = authorRepository.findById(getAuthorIdDto.getAuthorId()).get();
      for (Book book:author.getBooks())
      {
          GetBookResponseDto getBookResponseDto=new GetBookResponseDto();
          getBookResponseDto.setTitle(book.getTitle());
          getBookResponseDto.setGenre(book.getGenre());
          getBookResponseDto.setPrice(book.getPrice());
          getBookResponseDto.setNumberOfPages(book.getNumberOfPages());
          getBookResponseDto.setId(book.getId());

          res.add(getBookResponseDto);
      }

      return res;
  }

  @Override
  public int getNumberOfBooksByAuthor(GetAuthorNameDto getAuthorNameDto) {
    Author author=authorRepository.findByName(getAuthorNameDto.getAuthorName());

    return author.getBooks().size();
  }
}
