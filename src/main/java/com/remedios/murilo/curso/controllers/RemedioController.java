package com.remedios.murilo.curso.controllers;

import com.remedios.murilo.curso.remedio.*;
import com.remedios.murilo.curso.remedio.dtos.DadosAtualizarRemedio;
import com.remedios.murilo.curso.remedio.dtos.DadosCadastroRemedio;
import com.remedios.murilo.curso.remedio.dtos.DadosDetalhamentoRemedio;
import com.remedios.murilo.curso.remedio.dtos.DadosListagemRemedio;
import com.remedios.murilo.curso.remedio.repositories.RemedioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @Transactional // faz com que a transação seja revertida(rool back) se houver algum problema
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroRemedio dados){ //  void não retorna nada

        repository.save(new Remedio(dados));

    }

    @GetMapping
    public ResponseEntity<List<DadosListagemRemedio>> listar(){
         var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemRemedio::new).toList();

         return ResponseEntity.ok(lista);

    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> atualizar(@RequestBody @Valid DadosAtualizarRemedio dados){
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.inativar();

        return ResponseEntity.noContent().build();
    }

    @PutMapping("ativar/{id}")
    @Transactional
    public ResponseEntity<Void> ativar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.ativar();

        return ResponseEntity.noContent().build();
    }

}


