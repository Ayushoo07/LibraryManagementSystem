package com.example.LibraryManagementSystem.Services.Impl;

import com.example.LibraryManagementSystem.DTO.RequestDto.IssueBookDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.ReturnBookDto;
import com.example.LibraryManagementSystem.DTO.ResponseDto.IsssueBookResponseDto;
import com.example.LibraryManagementSystem.DTO.ResponseDto.ReturnBookResponse;
import com.example.LibraryManagementSystem.Entity.Book;
import com.example.LibraryManagementSystem.Entity.Card;import com.example.LibraryManagementSystem.Entity.Transaction;
import com.example.LibraryManagementSystem.Enums.CardStatus;import com.example.LibraryManagementSystem.Enums.TransactionStatus;
import com.example.LibraryManagementSystem.Repository.BookRepository;
import com.example.LibraryManagementSystem.Repository.CardRepository;import com.example.LibraryManagementSystem.Repository.TransactionRepository;import com.example.LibraryManagementSystem.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.Date;import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService
{
  @Autowired
  CardRepository cardRepository;


  @Autowired
  BookRepository bookRepository;


  @Autowired
  TransactionRepository transactionRepository;

    @Autowired
    private JavaMailSender emailSender;


  @Override
  public IsssueBookResponseDto issueBook(IssueBookDto issueBookDto)throws Exception {

      Transaction transaction=new Transaction();
      transaction.setIssueBookNo(String.valueOf(UUID.randomUUID()));


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
      transaction.setIssued(true);
      transaction.setReturnDate("Not returned");
      book.setIssued(true);
      book.setCard(card);
      book.getTransactionList().add(transaction);
      card.getBooksIssed().add(book);
      card.getTransactionList().add(transaction);
      transaction.setTransactionStatus(TransactionStatus.SUCCESS);

      IsssueBookResponseDto issueBookResponseDto=new IsssueBookResponseDto();
      issueBookResponseDto.setIssueBookNo(transaction.getIssueBookNo());
      issueBookResponseDto.setBookName(book.getTitle());
      issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());
      transactionRepository.save(transaction);

      String text = "Congrats! " + card.getStudent().getName() +  " You have been issued the book " + book.getTitle();
      SimpleMailMessage message = new SimpleMailMessage();
      message.setFrom("noreply@baeldung.com");
      message.setTo(card.getStudent().getEmail());
      message.setSubject(text);
      message.setText(text);
      emailSender.send(message);

      return issueBookResponseDto;
  }

  @Override
  public ReturnBookResponse returnBook(ReturnBookDto returnBookDto) throws Exception {
      Card card=cardRepository.findById(returnBookDto.getCardId()).get();
      Book book=bookRepository.findById(returnBookDto.getBookId()).get();
      for(Transaction transaction: card.getTransactionList())
      {
          if(transaction.getIssueBookNo().equals(returnBookDto.getIssueBookNo()))
          {
              Date date = new Date();
              transaction.setReturnDate(date.toString());
              transaction.setTransactionStatus(TransactionStatus.SUCCESS);
              transaction.setIssued(false);
              card.getBooksIssed().remove(book);
              book.setIssued(false);
              book.setCard(null);
              transactionRepository.save(transaction);

              ReturnBookResponse returnBookResponse = new ReturnBookResponse();
              returnBookResponse.setBookName(book.getTitle());
              returnBookResponse.setTransactionStatus(TransactionStatus.SUCCESS);
              returnBookResponse.setIssueBookNo(transaction.getIssueBookNo());

              String text = "Congrats! " + card.getStudent().getName() +  " You have Successfully returned the book " + book.getTitle()+"on"+date.toString() + "";
              SimpleMailMessage message = new SimpleMailMessage();
              message.setFrom("noreply@baeldung.com");
              message.setTo(card.getStudent().getEmail());
              message.setSubject("Book Returned Successfully");
              message.setText(text);
              emailSender.send(message);

              return returnBookResponse;
          }
      }

      throw new Exception("details not found in Database");








  }
}
