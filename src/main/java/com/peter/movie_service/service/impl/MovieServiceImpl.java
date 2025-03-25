package com.peter.movie_service.service.impl;

import com.peter.movie_service.dto.MovieRequestDTO;
import com.peter.movie_service.dto.MovieResponseDTO;
import com.peter.movie_service.exception.MovieNotFoundException;
import com.peter.movie_service.mapper.MovieMapper;
import com.peter.movie_service.model.Movie;
import com.peter.movie_service.repository.MovieRepository;
import com.peter.movie_service.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public List<MovieResponseDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();

        return movies.stream().map(MovieMapper::toDTO).toList();
    }

    public MovieResponseDTO getMovieById(Long id) {
        return movieRepository
                .findById(id)
                .map(MovieMapper::toDTO)
                .orElseThrow(() ->
                        new MovieNotFoundException("Movie with id: " + id + " not found!"));

    }

    public MovieResponseDTO saveMovie(MovieRequestDTO movieRequestDTO) {
        Movie newMovie = movieRepository.save(MovieMapper.toModel(movieRequestDTO));

        return MovieMapper.toDTO(newMovie);
    }

    public String deleteMovie(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return "Movie with id: " + id + " deleted successfully!";
        } else {
            throw new MovieNotFoundException("Movie with id: " + id + " not found!");
        }
    }
}
