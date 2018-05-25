/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.augustomesquita.basicstarter.controller;

import com.augustomesquita.basicstarter.model.User;
import com.augustomesquita.basicstarter.repositories.IUserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author augusto
 */
@Component
class AllUserDataFetcher implements DataFetcher<List<User>> {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> get(DataFetchingEnvironment env) {
        return (List<User>) userRepository.findAll();
    }

}
