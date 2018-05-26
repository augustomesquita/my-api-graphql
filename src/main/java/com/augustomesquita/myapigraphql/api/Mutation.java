package com.augustomesquita.myapigraphql.api;

import com.augustomesquita.myapigraphql.model.Movie;
import com.augustomesquita.myapigraphql.repositories.IMovieRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Augusto Mesquita
 */
@Component
public class Mutation implements GraphQLMutationResolver {

    private final Logger LOGGER = LoggerFactory.getLogger(Mutation.class);

    @Autowired
    private IMovieRepository movieRepository;

    /**
     * Cria um novo filme de acordo com os dados passados do mesmo.
     *
     * @param name
     * @param director
     * @return // Retorna status de ok com usuário que foi criado.
     */
    public Movie saveMovie(String name, String director) {
        Movie movieSaved = movieRepository.save(new Movie(name, director));
        if (movieSaved != null) {
            LOGGER.info("Criação do de filme de id: "
                    + movieSaved.getId());
        } else {
            LOGGER.info("Não foi possível criar o filme.");
        }
        return movieSaved;
    }

}
