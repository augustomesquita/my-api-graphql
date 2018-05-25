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
public class AllUserDataFetcher implements DataFetcher<List<User>> {

    private final Logger LOGGER = LoggerFactory.getLogger(AllUserDataFetcher.class);
    
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> get(DataFetchingEnvironment env) {
        LOGGER.info("Realização de busca de lista de usuários no banco.");
        return (List<User>) userRepository.findAll();
    }

}
