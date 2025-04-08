package com.example.backendZynetic.model;

import com.example.backendZynetic.DTO.BookDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    private String category;
    private Integer price;
    private Double rating;
    private LocalDate publishedDate;

    public BookDto toBookDto() {
        return BookDto.builder()
                .id(id)
                .title(title)
                .author(author)
                .category(category)
                .price(price)
                .rating(rating)
                .publishedDate(publishedDate)
                .build();
    }
}