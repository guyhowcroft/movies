package com.task.movies.controller;

import com.task.movies.pojo.Movie;
import com.task.movies.pojo.Movies;
import com.task.movies.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    public @ResponseBody Movies getMovies(){
        return moviesService.getMovies();
    }

    @GetMapping("/individualMovies")
    public @ResponseBody List<Movie> getInidivdualMovies(){
        return moviesService.getMovies().getMovies();
    }

    @GetMapping("/userWithMostComments")
    public @ResponseBody String getUserWithMostComments() {
        return moviesService.getMovies().getUserWithMostComments();
    }

    @GetMapping("/movieWithHighestLikes")
    public @ResponseBody String getMovieWithHighestLikes() {
        return moviesService.getMovies().getMovieWithMostLikes();
    }

}
