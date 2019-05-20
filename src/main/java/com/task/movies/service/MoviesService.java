package com.task.movies.service;

import com.task.movies.pojo.Movie;
import com.task.movies.pojo.Movies;

import java.util.List;

public interface MoviesService {

    Movies getMoviesData() throws Exception;

    List<Movie> getMovies() throws Exception;

    String getUserWithMostComments() throws Exception;

    String getMovieWithMostLikes() throws Exception;
}
