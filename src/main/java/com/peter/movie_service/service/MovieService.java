package com.peter.movie_service.service;

import com.peter.movie_service.dto.MovieRequestDTO;
import com.peter.movie_service.dto.MovieResponseDTO;
import com.peter.movie_service.model.Movie;

import java.util.List;

public interface MovieService {
    List<MovieResponseDTO> getAllMovies();
    MovieResponseDTO getMovieById(Long id);
    MovieResponseDTO saveMovie(MovieRequestDTO movieRequestDTO);
    String deleteMovie(Long id);
}
