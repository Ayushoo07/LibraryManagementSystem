package com.example.LibraryManagementSystem.DTO.RequestDto;

import com.example.LibraryManagementSystem.Enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddBookDto
{
    private Genre genre;

    private int numberOfPages;

    private int price;

    private String title;

    private int authorId;
}
