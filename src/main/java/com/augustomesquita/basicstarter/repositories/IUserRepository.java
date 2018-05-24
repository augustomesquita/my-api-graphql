/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.augustomesquita.basicstarter.repositories;

import com.augustomesquita.basicstarter.model.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author augusto
 */
public interface IUserRepository extends CrudRepository<User, Long> {
    List<User> findByName(String name);
}
