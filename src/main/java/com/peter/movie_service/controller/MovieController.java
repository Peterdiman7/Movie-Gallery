package com.peter.movie_service.controller;

import com.peter.movie_service.dto.MovieRequestDTO;
import com.peter.movie_service.dto.MovieResponseDTO;
import com.peter.movie_service.model.Movie;
import com.peter.movie_service.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")  // Allow requests from anywhere
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieResponseDTO>> getAllMovies() {
        List<MovieResponseDTO> movieResponseDTOS = movieService.getAllMovies();

        return ResponseEntity.ok(movieResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> getMovieById(@PathVariable("id") Long id) {
        MovieResponseDTO movieDTO = movieService.getMovieById(id);

        return ResponseEntity.ok(movieDTO);
    }

    @PostMapping
    public ResponseEntity<MovieResponseDTO> saveMovie(@RequestBody MovieRequestDTO movieRequestDTO) {
        MovieResponseDTO newMovie = movieService.saveMovie(movieRequestDTO);

        return ResponseEntity.ok(newMovie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> updateMovie(
            @PathVariable("id") Long id,
            @RequestBody MovieRequestDTO movieRequestDTO) {
        MovieResponseDTO updatedMovie = movieService.updateMovie(id, movieRequestDTO);
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteMovie(
            @PathVariable("id") long id
    ) {
        String message = movieService.deleteMovie(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", message);

        return ResponseEntity.ok(response);
    }
}
