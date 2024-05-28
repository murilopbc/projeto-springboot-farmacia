package com.remedios.murilo.curso.remedio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//  Entidade, atributo que define/idenificação - generics: passar objetos
public interface RemedioRepository extends JpaRepository<Remedio,Long> {

    List<Remedio> findAllByAtivoTrue();
}
