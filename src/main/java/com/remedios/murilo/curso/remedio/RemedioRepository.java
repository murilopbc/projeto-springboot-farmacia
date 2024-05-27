package com.remedios.murilo.curso.remedio;

import org.springframework.data.jpa.repository.JpaRepository;
                                                        //  generics - passar objetos
public interface RemedioRepository extends JpaRepository<Remedio,Long> {
}
