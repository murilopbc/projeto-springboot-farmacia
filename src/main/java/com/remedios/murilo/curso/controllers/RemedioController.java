package com.remedios.murilo.curso.controllers;

import com.remedios.murilo.curso.remedio.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// Padrão DTO(Data Transfer Object): Filtra as informações que serão exibidas ao usuário.
// Ex: A senha não deve ser mostrada por questão de segurança
// JPA - Responsável por persistir os dados dentro do banco de dados
// Flyway: Ferramenta que serve para controle de versionamento de tabelas dentro do banco de dados


@RestController
@RequestMapping("/remedios")
public class RemedioController {


    @Autowired
    private RemedioRepository repository;

    @PostMapping
    @Transactional // faz com que a transação seja revertida se houver algum problema
    public void cadastrar(@RequestBody @Valid DadosCadastroRemedio dados){ //  void não retorna nada

        repository.save(new Remedio(dados));

    }

    @GetMapping
    public List<DadosListagemRemedio> listar(){
        return repository.findAllByAtivoTrue().stream().map(DadosListagemRemedio::new).toList();

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarRemedio dados){
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);

    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public void inativar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.inativar();
    }

    @PutMapping("ativar/{id}")
    @Transactional
    public void ativar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.ativar();
    }

}


