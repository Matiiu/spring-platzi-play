package com.platzi.play.persistence.crud;

import com.platzi.play.persistence.entity.MovieEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudMovieEntity extends JpaRepository<MovieEntity, Long> {
    MovieEntity findFirstByTitulo(String titulo);
}
