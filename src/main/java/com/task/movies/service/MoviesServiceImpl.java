package com.task.movies.service;

import com.task.movies.dao.MoviesDao;
import com.task.movies.pojo.Movie;
import com.task.movies.pojo.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService{

    @Autowired
    private MoviesDao moviesDaoFile;

    private Movies movies;

    public Movies getMoviesData() throws Exception {

        Movies movies = new Movies();
        movies.setMovies(getMovies());
        movies.setUserWithMostComments(getUserWithMostComments());
        movies.setMovieWithMostLikes(getMovieWithMostLikes());

        return movies;
    }

    public List<Movie> getMovies() throws Exception {
        return moviesDaoFile.getMovies();
    }

    public String getUserWithMostComments() throws Exception {
        return moviesDaoFile.getUserWithMostComments();
    }

    public String getMovieWithMostLikes() throws Exception {
        return moviesDaoFile.getMovieWithMostLikes();
    }
}
