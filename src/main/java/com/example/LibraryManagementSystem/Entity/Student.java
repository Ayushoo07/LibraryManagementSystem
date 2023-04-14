package com.example.LibraryManagementSystem.Entity;

import com.example.LibraryManagementSystem.Enums.Department;import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private Department department;

    private String mobNo;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    Card card;
}
