package com.peter.movie_service.mapper;

import com.peter.movie_service.dto.MovieRequestDTO;
import com.peter.movie_service.dto.MovieResponseDTO;
import com.peter.movie_service.model.Movie;

import java.time.LocalDate;

public class MovieMapper {

    public static MovieResponseDTO toDTO(Movie movie) {
        MovieResponseDTO movieDTO = new MovieResponseDTO();

        movieDTO.setId(movie.getId());
        movieDTO.setDirector(movie.getDirector());
        movieDTO.setGenre(movie.getGenre());
        movieDTO.setReleaseYear(movie.getReleaseYear());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setImageUrl(movie.getImageUrl());

        return movieDTO;
    }

    public static Movie toModel(MovieRequestDTO movieRequestDTO) {
        Movie movie = new Movie();
        movie.setId(movieRequestDTO.getId());
        movie.setDirector(movieRequestDTO.getDirector());
        movie.setGenre(movieRequestDTO.getGenre());
        movie.setReleaseYear(movieRequestDTO.getReleaseYear());
        movie.setTitle(movieRequestDTO.getTitle());
        movie.setImageUrl(movieRequestDTO.getImageUrl());
        movie.setCreatedAt(LocalDate.parse(movieRequestDTO.getCreatedAt()));

        return movie;
    }
}
