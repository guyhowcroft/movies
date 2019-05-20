package com.task.movies.controller;

import com.task.movies.pojo.Movie;
import com.task.movies.pojo.Movies;
import com.task.movies.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MoviesService moviesService;

    @RequestMapping("/")
    public String home() {
        return "movies";
    }

    @GetMapping("/movies")
    public @ResponseBody Movies getMovies() throws Exception {
        return moviesService.getMoviesData();
    }

    @GetMapping("/individualMovies")
    public @ResponseBody List<Movie> getInidivdualMovies() throws Exception {
        return moviesService.getMovies();
    }

    @GetMapping("/userWithMostComments")
    public @ResponseBody String getUserWithMostComments() throws Exception {
        return moviesService.getUserWithMostComments();
    }

    @GetMapping("/movieWithHighestLikes")
    public @ResponseBody String getMovieWithHighestLikes() throws Exception {
        return moviesService.getMovieWithMostLikes();
    }

}
