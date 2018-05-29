package com.augustomesquita.myapigraphql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Augusto Mesquita
 */
@Entity
@Table(name = "movie")
public class Movie {

    private Long id;
    private String name;
    private String director;

    public Movie() {
    }

    public Movie(String name, String director) {
        this.name = name;
        this.director = director;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", name=" + name + ", director=" + director + '}';
    }

}
