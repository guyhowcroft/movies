package com.task.movies.dao;

import com.google.gson.Gson;
import com.task.movies.pojo.Comment;
import com.task.movies.pojo.Movie;
import com.task.movies.pojo.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Repository
public class MoviesDaoFile implements MoviesDao{

    @Autowired
    ResourceLoader resourceLoader;

    private List<Movie> moviesList;

    private String movieWithMostLikes;

    private String userWithMostComments;

    private List<Movie> importData() throws IOException {

        Gson gson = new Gson();

        Resource resource = resourceLoader.getResource("classpath:json/movies.json");

        Reader reader = new FileReader(resource.getFile().getAbsolutePath());
        Movies movies = gson.fromJson(reader, Movies.class);

        return movies.getMovies();
    }

    private void setStats(){

        int likes = 0;
        String movieName = "";

        HashMap<String, Integer> userCommentMap = new HashMap<>();

        for(Movie movie: moviesList){

            //compare to highest likes
            if(movie.getLikes() > likes){
                likes = movie.getLikes();
                movieName = movie.getTitle();
            }
            countUserComments(movie, userCommentMap);
        }

        //find key with the highest value
        String user = Collections.max(userCommentMap.entrySet(), HashMap.Entry.comparingByValue()).getKey();

        movieWithMostLikes = movieName;
        userWithMostComments = user;
    }

    private void countUserComments(Movie movie, HashMap<String, Integer> userCommentMap){

        for(Comment comment : movie.getComments()){
            //check count for that user
            int count = userCommentMap.containsKey(comment.getUser()) ? userCommentMap.get(comment.getUser()) : 0;
            //add 1 to the count if exists
            userCommentMap.put(comment.getUser(), count + 1);
        }
    }

    public List<Movie> getMovies() throws IOException {

        if (moviesList == null) {
            moviesList = importData();
        }
        return moviesList;
    }

    public String getMovieWithMostLikes() throws IOException {

        if(movieWithMostLikes == null){
            getMovies();
            setStats();
        }
        return movieWithMostLikes;
    }

    public String getUserWithMostComments() throws IOException {

        if(userWithMostComments == null){
            getMovies();
            setStats();
        }
        return userWithMostComments;
    }
}
