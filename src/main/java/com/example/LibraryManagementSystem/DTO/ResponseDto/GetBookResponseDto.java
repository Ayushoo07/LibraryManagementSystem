package com.example.LibraryManagementSystem.DTO.ResponseDto;

import com.example.LibraryManagementSystem.Enums.Genre;import jakarta.persistence.EnumType;import jakarta.persistence.Enumerated;import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetBookResponseDto
{
    private int id;

    private String title;

    private Genre genre;

    private int numberOfPages;

    private int price;
}
