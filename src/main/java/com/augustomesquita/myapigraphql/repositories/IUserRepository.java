/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.augustomesquita.myapigraphql.repositories;

import com.augustomesquita.myapigraphql.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author augusto
 */
public interface IUserRepository extends CrudRepository<User, Long> {
}
