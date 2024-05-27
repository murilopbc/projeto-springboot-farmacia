package com.remedios.murilo.curso.controllers;

import com.remedios.murilo.curso.remedio.DadosCadastroRemedio;
import com.remedios.murilo.curso.remedio.Remedio;
import com.remedios.murilo.curso.remedio.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Padrão DTO(Data Transfer Object): Filtra as informações que serão exibidas ao usuário.
// Ex: A senha não deve ser mostrada por questão de segurança
// JPA - Responsável por persistir os dados dentro do banco de dados


@RestController
@RequestMapping("/remedios")
public class RemedioController {


    @Autowired
    private RemedioRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroRemedio dados){

        repository.save(new Remedio(dados));

    }
}


