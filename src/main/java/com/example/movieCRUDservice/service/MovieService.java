package com.example.movieCRUDservice.service;

import com.example.movieCRUDservice.exception.MovieNotFoundException;
import com.example.movieCRUDservice.model.Movie;
import com.example.movieCRUDservice.repo.MovieRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    //injecting repository
    @Autowired
    private MovieRepo movieRepo;

    public Movie saveMovie(Movie movie) {

        return movieRepo.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }


    public Movie findByMovieId(Long movieId) throws MovieNotFoundException {

        Movie movie = movieRepo.findByMovieId(movieId);
        if (movie != null){
            return movie;
        }else {
            throw new MovieNotFoundException("User not found");
        }

    }

    public void deleteByMovieId(Long movieId) {
        movieRepo.deleteById(movieId);
    }


    public List<Movie> filterMovies() {
        return movieRepo.findAll(Sort.by(Sort.Direction.ASC, "date"));
    }
}
