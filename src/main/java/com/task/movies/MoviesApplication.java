package com.task.movies;

import com.task.movies.service.MoviesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviesApplication {

    @Autowired
    private MoviesServiceImpl moviesService;

    public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

}
