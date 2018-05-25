/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.augustomesquita.myapigraphql;

import com.augustomesquita.myapigraphql.exception.GraphQLErrorAdapter;
import com.augustomesquita.myapigraphql.query.Query;
import com.augustomesquita.myapigraphql.query.UserResolver;
import com.augustomesquita.myapigraphql.repositories.IMovieRepository;
import com.augustomesquita.myapigraphql.repositories.IUserRepository;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author augusto
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.augustomesquita.myapigraphql")
public class JApplication {

    public static void main(String[] args) {
        SpringApplication.run(JApplication.class, args);
    }

    @Bean
    public GraphQLErrorHandler errorHandler() {
        return new GraphQLErrorHandler() {
            @Override
            public List<GraphQLError> processErrors(List<GraphQLError> errors) {
                List<GraphQLError> clientErrors = errors.stream()
                        .filter(this::isClientError)
                        .collect(Collectors.toList());

                List<GraphQLError> serverErrors = errors.stream()
                        .filter(e -> !isClientError(e))
                        .map(GraphQLErrorAdapter::new)
                        .collect(Collectors.toList());

                List<GraphQLError> e = new ArrayList<>();
                e.addAll(clientErrors);
                e.addAll(serverErrors);
                return e;
            }

            protected boolean isClientError(GraphQLError error) {
                return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
            }
        };
    }

    @Bean
    public UserResolver movieResolver(IMovieRepository movieRepository) {
        return new UserResolver(movieRepository);
    }

    @Bean
    public Query query(IUserRepository userRepository, IMovieRepository movieRepository) {
        return new Query(userRepository, movieRepository);
    }

}
