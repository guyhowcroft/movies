package com.task.movies.pojo;

import java.util.List;

public class Movies {

    private List<Movie> movies;

    private String userWithMostComments;

    private String movieWithMostLikes;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getUserWithMostComments() {
        return userWithMostComments;
    }

    public void setUserWithMostComments(String userWithMostComments) {
        this.userWithMostComments = userWithMostComments;
    }

    public String getMovieWithMostLikes() {
        return movieWithMostLikes;
    }

    public void setMovieWithMostLikes(String movieWithMostLikes) {
        this.movieWithMostLikes = movieWithMostLikes;
    }
}
