package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO salvarScore(ScoreDTO dto){

        User user = userRepository.findByEmail(dto.getEmail() );
        if (user == null){
            user = new User();
            user.setEmail(dto.getEmail());

            /*
            saveAndFlush: syncronizing the state with underlaying bd
            save method: Normally, Hibernate holds the persistable
                         state in memory.
                         Fica Aguardando um flush, um rollback, ou
                         um commit
             */
            user = userRepository.saveAndFlush(user);
        }

        /*
        findById retorna um java.util.Optional.
        Por isso tem que dar um get() no final
        */
        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setScore(dto.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s : movie.getScores()){
            sum = sum + s.getScore();

        }

        double avg = sum / movie.getScores().size();
        movie.setScore(avg);
        movie = movieRepository.save(movie);

        return new MovieDTO(movie);

    }

}
