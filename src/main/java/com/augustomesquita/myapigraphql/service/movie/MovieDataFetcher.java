package com.augustomesquita.myapigraphql.service.movie;

import com.augustomesquita.myapigraphql.model.Movie;
import com.augustomesquita.myapigraphql.model.User;
import com.augustomesquita.myapigraphql.repositories.IMovieRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Augusto Mesquita
 */
@Component
public class MovieDataFetcher implements DataFetcher<Movie> {

    private final Logger LOGGER = LoggerFactory.getLogger(MovieDataFetcher.class);

    @Autowired
    private IMovieRepository movieRepository;

    @Override
    public Movie get(DataFetchingEnvironment env) {
        LOGGER.info("Realização de busca de filme por 'id' no banco.");
        User user = (User) env.getSource();
        return movieRepository.findById(user.getMovie().getId()).get();
    }

}
