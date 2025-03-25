package com.peter.movie_service.dto;

import lombok.Data;

@Data
public class MovieResponseDTO {
    private Long id;
    private String title;
    private String director;
    private String genre;
    private int releaseYear;
    private String imageUrl;
}
