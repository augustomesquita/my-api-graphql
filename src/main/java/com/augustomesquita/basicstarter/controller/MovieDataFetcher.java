package com.augustomesquita.basicstarter.controller;

import com.augustomesquita.basicstarter.model.Movie;
import com.augustomesquita.basicstarter.model.User;
import com.augustomesquita.basicstarter.repositories.IMovieRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Augusto Mesquita
 */
@Component
public class MovieDataFetcher implements DataFetcher<Movie>{

    @Autowired
    private IMovieRepository movieRepository;
    
    @Override
    public Movie get(DataFetchingEnvironment env) {
        User user = (User) env.getSource();
        return movieRepository.findById(user.getMovie().getId()).get();
    }
    
}
