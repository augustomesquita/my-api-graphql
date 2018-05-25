/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.augustomesquita.myapigraphql.resolvers;

import com.augustomesquita.myapigraphql.model.User;
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
public class JUserQuery implements GraphQLQueryResolver {

    private final Logger LOGGER = LoggerFactory.getLogger(JUserQuery.class);

    @Autowired
    private IUserRepository userRepository;

    public User getUser(Long id) {
        LOGGER.info("Realização de busca de usuário por 'id' no banco.");
        return userRepository.findById(id).get();
    }

    public List<User> getAllUser() {
        LOGGER.info("Realização de busca de lista de usuários no banco.");
        return (List<User>) userRepository.findAll();
    }
}
