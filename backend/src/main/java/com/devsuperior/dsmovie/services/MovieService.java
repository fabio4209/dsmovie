package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Transactional
    public Page<MovieDTO> encontrarTodos(Pageable pageable){
        Page<Movie> result = repository.findAll(pageable);
        //Converte o resultado pra DTO
        Page<MovieDTO> page = result.map( x -> new MovieDTO(x));
        return page;
    }

    @Transactional
    public MovieDTO encontrarPorID(Long id) {
        Movie result = repository.findById(id).get();
        MovieDTO dto = new MovieDTO(result);
        return dto;
    }

}
