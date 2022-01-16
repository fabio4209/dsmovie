package com.devsuperior.dsmovie.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double score;
    private Integer count;
    private String image;

    /*
    @OneToMany:
    Por que "id.movie" ?
        id -> Nome do atributo na entidade Score, do tipo ScorePK
        movie -> Dentro da entidade ScorePK o nome do atributo é movie

    A partir de scores eu consigo acessar todas as avaliações
        de um determinado filme a partir da entidade Movie
     */
    @OneToMany(mappedBy = "id.movie")
    private Set<Score> scores = new HashSet<>();



    public Movie(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }


}
