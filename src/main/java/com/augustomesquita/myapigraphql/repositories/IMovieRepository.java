package com.augustomesquita.myapigraphql.repositories;

import com.augustomesquita.myapigraphql.model.Movie;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Augusto Mesquita
 */
public interface IMovieRepository extends CrudRepository<Movie, Long> {
}
