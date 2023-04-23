package com.example.LibraryManagementSystem.Entity;

import com.example.LibraryManagementSystem.Enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private int id;

    private String issueBookNo;

  @CreationTimestamp
  private Date issueDate;

  private String returnDate;

    boolean isIssued;

  @Enumerated(EnumType.STRING)
  private TransactionStatus transactionStatus;

    @ManyToOne
    @JoinColumn
    Card card;

    @ManyToOne
    @JoinColumn
    Book book;

}
