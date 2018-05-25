package com.augustomesquita.basicstarter.repositories;

import com.augustomesquita.basicstarter.model.Movie;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Augusto Mesquita
 */
public interface IMovieRepository extends CrudRepository<Movie, Long> {
}
