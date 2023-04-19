package com.example.LibraryManagementSystem.Services.Impl;

import com.example.LibraryManagementSystem.DTO.RequestDto.IssueBookDto;
import com.example.LibraryManagementSystem.DTO.ResponseDto.IsssueBookResponseDto;
import com.example.LibraryManagementSystem.Entity.Book;import com.example.LibraryManagementSystem.Entity.Card;import com.example.LibraryManagementSystem.Entity.Transaction;
import com.example.LibraryManagementSystem.Enums.CardStatus;import com.example.LibraryManagementSystem.Enums.TransactionStatus;
import com.example.LibraryManagementSystem.Repository.BookRepository;
import com.example.LibraryManagementSystem.Repository.CardRepository;import com.example.LibraryManagementSystem.Repository.TransactionRepository;import com.example.LibraryManagementSystem.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService
{
  @Autowired
  CardRepository cardRepository;


  @Autowired
  BookRepository bookRepository;


  @Autowired
  TransactionRepository transactionRepository;


  @Override
  public IsssueBookResponseDto issueBook(IssueBookDto issueBookDto)throws Exception {

      Transaction transaction=new Transaction();
      transaction.setIssueBookNo(String.valueOf(UUID.randomUUID()));
      transaction.setIssued(true);

      Card card;
      try {
          card=cardRepository.findById(issueBookDto.getCardId()).get();
      }
      catch (Exception e)
      {
        transaction.setTransactionStatus(TransactionStatus.FAILURE);
        transactionRepository.save(transaction);
        throw new Exception("Card Not Found");
      }
      transaction.setCard(card);

      Book book;

      try {
          book=bookRepository.findById(issueBookDto.getBookId()).get();
      }
      catch (Exception e)
      {
          transaction.setTransactionStatus(TransactionStatus.FAILURE);
          transactionRepository.save(transaction);

          throw new Exception("Book Not Found");
      }
      transaction.setBook(book);
      if(card.getCardStatus()!=CardStatus.ACTIVATED)
      {
          transaction.setTransactionStatus(TransactionStatus.FAILURE);
          transactionRepository.save(transaction);
          throw new Exception("card is Not Activated");
      }

      if(book.isIssued()==true)
      {
          transaction.setTransactionStatus(TransactionStatus.FAILURE);
          transactionRepository.save(transaction);
          throw new Exception("Book is Already issued");
      }
      book.setIssued(true);
      book.setCard(card);
      book.getTransactionList().add(transaction);
      card.getBooksIssed().add(book);
      card.getTransactionList().add(transaction);

      IsssueBookResponseDto issueBookResponseDto=new IsssueBookResponseDto();
      issueBookResponseDto.setIssueBookNo(transaction.getIssueBookNo());
      issueBookResponseDto.setBookName(book.getTitle());
      issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());

      return issueBookResponseDto;
  }


}
