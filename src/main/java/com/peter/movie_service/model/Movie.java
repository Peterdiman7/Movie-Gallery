package com.peter.movie_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@RequiredArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String director;

    @NotNull
    private String genre;

    @NotNull
    private int releaseYear;

    @NotNull
    private String imageUrl;

    @NotNull
    private LocalDate createdAt;
}
