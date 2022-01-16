package com.devsuperior.dsmovie.repositories;

import com.devsuperior.dsmovie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    /* ***MÉTODOS CUSTOMISADOS***
       Faz SELECT por QUALQUER campo:
       Criar o método com nome no padrão:
       findBy[nome-do-campo]([tipo-do-campo] [nome-do-campo]){}
       Dessa forma não precisa implementar nada.
       O SPRINT JPA já entende e sabe o que é pra fazer*/
    User findByEmail(String email);

}