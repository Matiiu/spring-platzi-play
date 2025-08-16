package com.platzi.play.persistence.entity;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.UpdateMovieDto;
import com.platzi.play.domain.exception.MovieAlreadyExistException;
import com.platzi.play.domain.exception.MovieNotFound;
import com.platzi.play.domain.repository.MovieRepository;
import com.platzi.play.persistence.crud.CrudMovieEntity;
import com.platzi.play.persistence.mapper.MovieMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {
    private final CrudMovieEntity  crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public MovieDto save(MovieDto movieDto) {
        if (this.crudMovieEntity.findFirstByTitulo(movieDto.title()) != null) {
            throw new MovieAlreadyExistException(movieDto.title());
        }
        MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);
        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public List<MovieDto> getAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "titulo");
        return this.movieMapper.toDto(this.crudMovieEntity.findAll(sort));
    }

    @Override
    public MovieDto getById(long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElseThrow(MovieNotFound::new);

        return this.movieMapper.toDto(movieEntity);
    }

    @Override
    public MovieDto update(long id, UpdateMovieDto updateMovieDto) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElseThrow(MovieNotFound::new);

        if (!movieEntity.getTitulo().equals(updateMovieDto.title())) {
            MovieEntity existingMovie = this.crudMovieEntity.findFirstByTitulo(updateMovieDto.title());
            if (existingMovie != null) {
                throw new MovieAlreadyExistException(updateMovieDto.title());
            }
        }

        this.movieMapper.updateEntityFromDto(updateMovieDto, movieEntity);

        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public void deleteById(long id) {
        var movieEntity = crudMovieEntity.findById(id).orElseThrow(MovieNotFound::new);
        this.crudMovieEntity.delete(movieEntity);
    }
}
