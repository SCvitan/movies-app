package com.example.movieCRUDservice.repo;

import com.example.movieCRUDservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {


    Movie findByMovieId(Long movieId);


}
