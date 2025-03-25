package com.peter.movie_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MovieRequestDTO {

    private Long id;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title name cannot exceed 100 characters!")
    private String title;

    @NotBlank(message = "Director is required")
    @Size(max = 100, message = "Director name cannot exceed 100 characters!")
    private String director;

    @NotBlank(message = "Genre is required")
    @Size(max = 100, message = "Genre name cannot exceed 100 characters!")
    private String genre;

    @NotBlank(message = "Release Year is required!")
    private int releaseYear;

    @NotBlank(message = "Image URL is required!")
    private String imageUrl;

    @NotBlank(message = "CreatedAt date is required")
    private String createdAt;
}
