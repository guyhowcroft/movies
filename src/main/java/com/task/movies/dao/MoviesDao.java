package com.task.movies.dao;

import com.task.movies.pojo.Movie;

import java.io.IOException;
import java.util.List;

public interface MoviesDao {

    List<Movie> getMovies() throws Exception;

    String getMovieWithMostLikes() throws Exception;

    String getUserWithMostComments() throws Exception;

}
