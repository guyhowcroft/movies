package com.task.movies.service;

import com.google.gson.Gson;
import com.task.movies.pojo.Comment;
import com.task.movies.pojo.Movie;
import com.task.movies.pojo.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;

@Service
public class MoviesService {

    @Autowired
    ResourceLoader resourceLoader;

    private Movies movies;

    @PostConstruct
    public void importData() {

        Gson gson = new Gson();

        Resource resource = resourceLoader.getResource("classpath:json/movies.json");

        try (Reader reader = new FileReader(resource.getFile().getAbsolutePath())) {

            // Convert JSON File to Java Object
            movies = gson.fromJson(reader, Movies.class);

            //set stats required after read
            setStats();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setStats(){

        int likes = 0;
        String movieName = "";

        HashMap<String, Integer> userCommentMap = new HashMap<>();

        for(Movie movie: movies.getMovies()){

            //compare to highest likes
            if(movie.getLikes() > likes){
                likes = movie.getLikes();
                movieName = movie.getTitle();
            }
            countUserComments(movie, userCommentMap);
        }

        //find key with the highest value
        String user = Collections.max(userCommentMap.entrySet(), HashMap.Entry.comparingByValue()).getKey();

        movies.setMovieWithMostLikes(movieName);
        movies.setUserWithMostComments(user);

    }

    private void countUserComments(Movie movie, HashMap<String, Integer> userCommentMap){

        for(Comment comment : movie.getComments()){
            //check count for that user
            int count = userCommentMap.containsKey(comment.getUser()) ? userCommentMap.get(comment.getUser()) : 0;
            //add 1 to the count if exists
            userCommentMap.put(comment.getUser(), count + 1);
        }
    }

    public Movies getMovies() {
        return movies;
    }
}
