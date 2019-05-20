package com.task.movies;

import com.task.movies.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MoviesApplication {

    @Autowired
    private MoviesService moviesService;

    public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

}
