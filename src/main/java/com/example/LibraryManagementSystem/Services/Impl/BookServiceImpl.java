package com.example.LibraryManagementSystem.Services.Impl;

import com.example.LibraryManagementSystem.DTO.RequestDto.AddBookDto;import com.example.LibraryManagementSystem.Entity.Author;import com.example.LibraryManagementSystem.Entity.Book;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;import com.example.LibraryManagementSystem.Repository.StudentRepository;import com.example.LibraryManagementSystem.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;

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
}
