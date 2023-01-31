package com.example.movieCRUDservice.controller;

import com.example.movieCRUDservice.exception.MovieNotFoundException;
import com.example.movieCRUDservice.model.Movie;
import com.example.movieCRUDservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/movie")
public class MovieController {

    //injecting service
    @Autowired
    private MovieService movieService;

    @PostMapping("/save")
    public Movie saveMovie(@RequestBody Movie movie){

        return movieService.saveMovie(movie);
    }

    @GetMapping("/all")
    public List<Movie> getAllMovies(){

        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovie( @PathVariable("id") Long movieId ) throws MovieNotFoundException {

       return movieService.findByMovieId(movieId);

    }

    @DeleteMapping("/{id}")
    public void deleteMovie( @PathVariable("id") Long movieId ){
         movieService.deleteByMovieId(movieId);

    }

    @PutMapping("/update/{id}")
    public Movie updateMovie( @PathVariable("id") Long movieId, @RequestBody Movie movieDetails ) throws MovieNotFoundException {
        Movie movie = movieService.findByMovieId(movieId);
        movie.setTitle(movieDetails.getTitle());
        movie.setDate(movieDetails.getDate());
        movie.setRank(movieDetails.getRank());
        movie.setRevenue(movieDetails.getRevenue());

        Movie updatedMovie = movieService.saveMovie(movie);
        return updatedMovie;
    }

    @GetMapping("/filter")
    public List<Movie> filterMovies(){
        return movieService.filterMovies();
    }



}
