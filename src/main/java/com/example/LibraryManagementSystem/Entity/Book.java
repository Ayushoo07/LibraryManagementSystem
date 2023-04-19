package com.example.LibraryManagementSystem.Entity;


import com.example.LibraryManagementSystem.Enums.Genre;import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;import java.util.ArrayList;import java.util.List;

@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private int numberOfPages;

    private int price;

    private  boolean isIssued=false;

    @ManyToOne
    @JoinColumn
    Author author;

    @ManyToOne
    @JoinColumn
    Card card;

  @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
  List<Transaction> TransactionList = new ArrayList<>();
}
