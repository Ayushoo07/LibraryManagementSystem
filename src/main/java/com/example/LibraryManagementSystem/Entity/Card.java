package com.example.LibraryManagementSystem.Entity;


import com.example.LibraryManagementSystem.Enums.CardStatus;import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;

@Entity
@Table(name = "card")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Card
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private Date issueDate;

    @UpdateTimestamp
    private Date updatedOn;

    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

    private String validTill;

    @OneToOne
    @JoinColumn
    Student student;
}
