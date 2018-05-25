/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.augustomesquita.myapigraphql.service.user;

import com.augustomesquita.myapigraphql.model.User;
import com.augustomesquita.myapigraphql.repositories.IUserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author augusto
 */
@Component
public class UserDataFetcher implements DataFetcher<User> {

    private final Logger LOGGER = LoggerFactory.getLogger(UserDataFetcher.class);
    
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User get(DataFetchingEnvironment env) {
        LOGGER.info("Realização de busca de usuário por 'id' no banco.");
        return userRepository.findById(env.getArgument("id")).get();
    }

}
