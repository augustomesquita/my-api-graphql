/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.augustomesquita.myapigraphql.query;

import com.augustomesquita.myapigraphql.model.Movie;
import com.augustomesquita.myapigraphql.model.User;
import com.augustomesquita.myapigraphql.repositories.IMovieRepository;
import com.augustomesquita.myapigraphql.repositories.IUserRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author augusto
 */
@Component
public class Query implements GraphQLQueryResolver {

    private final Logger LOGGER = LoggerFactory.getLogger(Query.class);

    @Autowired
    private IUserRepository userRepository;
    
    @Autowired
    private IMovieRepository movieRepository;

    public User getUser(Long id) {
        LOGGER.info("Realização de busca de usuário de id: " + id);
        return userRepository.findById(id).get();
    }

    public List<User> getAllUser() {
        LOGGER.info("Realização de busca de lista de usuários no banco.");
        return (List<User>) userRepository.findAll();
    }

    public List<Movie> getAllMovies() {
        LOGGER.info("Realização de busca de lista filmes no banco.");
        return (List<Movie>) movieRepository.findAll();
    }

}
