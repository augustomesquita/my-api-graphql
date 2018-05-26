/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.augustomesquita.myapigraphql.resolvers;

import com.augustomesquita.myapigraphql.model.Movie;
import com.augustomesquita.myapigraphql.model.User;
import com.augustomesquita.myapigraphql.repositories.IMovieRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author augusto
 */
@Component
public class UserResolver implements GraphQLResolver<User> {

    private final Logger LOGGER = LoggerFactory.getLogger(UserResolver.class);

    @Autowired
    private IMovieRepository movieRepository;

    public Movie getMovie(User user) {
        LOGGER.info("Realização de busca de filme do usuário '" + user.getName() + "' no banco.");
        return movieRepository.findById(user.getMovie().getId()).get();
    }
}
