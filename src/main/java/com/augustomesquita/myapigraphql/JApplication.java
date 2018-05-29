/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.augustomesquita.myapigraphql;

import com.augustomesquita.myapigraphql.exception.GraphQLErrorHandlerBuilder;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author Augusto Mesquita
 */
@SpringBootApplication
@ComponentScan
public class JApplication {

    public static void main(String[] args) {
        SpringApplication.run(JApplication.class, args);
    }

    @Bean
    public GraphQLErrorHandler errorHandler() {
        return GraphQLErrorHandlerBuilder.graphQLErrorHandlerBuild();
    }

}
