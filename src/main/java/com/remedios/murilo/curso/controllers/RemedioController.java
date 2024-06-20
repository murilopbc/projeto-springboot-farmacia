package com.remedios.murilo.curso.controllers;

import com.remedios.murilo.curso.entities.*;
import com.remedios.murilo.curso.dtos.remedios.DadosAtualizarRemedio;
import com.remedios.murilo.curso.dtos.remedios.DadosCadastroRemedio;
import com.remedios.murilo.curso.dtos.remedios.DadosDetalhamentoRemedio;
import com.remedios.murilo.curso.dtos.remedios.DadosListagemRemedio;
import com.remedios.murilo.curso.repositories.RemedioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


// Padrão DTO(Data Transfer Object): Filtra as informações que serão exibidas ao usuário.
// Ex: A senha não deve ser mostrada por questão de segurança
// JPA - Responsável por persistir os dados dentro do banco de dados
// Flyway: Ferramenta que serve para controle de versionamento de tabelas dentro do banco de dados
// Response Entity : Classe que faz com que retorne o código correto das requisições


@RestController
@RequestMapping("/remedios")
@SecurityRequirement(name = "bearer-key")
public class RemedioController {

    @Autowired
    private RemedioService service;

    // Valid mostra que os dados precisam estar validados

    // Transactional - Faz com que se caso algum erro acontecer nesta requisição ela reverte toda a alteração feita
    // evita uma perda de dados indesejada

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastre um Remédio!",
            description ="Cadastre um Remédio!",
            tags = {"Remedios"})
    public ResponseEntity<RemedioDTO> create(@RequestBody @Valid InRemedioDTO dados, UriComponentsBuilder uriBuilder){

        RemedioDTO remedio =  service.create(dados);

        var uri = uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.id()).toUri();

        return ResponseEntity.created(uri).body(remedio);
    }

    @GetMapping
    @Operation(summary = "Buscar todos os Remédios!",
            description ="Buscar todos os Remédios!",
            tags = {"Remedios"})
    public ResponseEntity<List<OutRemedioDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Detalhar Remédio por ID!",
            description ="Detalhar Remédio por ID!",
            tags = {"Remedios"})
    public ResponseEntity<RemedioDTO>detalhar(@PathVariable Long id){
        return new ResponseEntity<>(service.detalhar(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @Transactional
    @Operation(summary = "Atualizar Remédio!",
            description ="Atualizar Remédio!",
            tags = {"Remedios"})
    public ResponseEntity<OutRemedioDTO> atualizar(@PathVariable Long id, @RequestBody @Valid UptRemedioDTO dados){
        return new ResponseEntity<>(service.atualizar(id, dados), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Deletar Remédio!",
            description ="Deletar Remédio!",
            tags = {"Remedios"})
    public ResponseEntity<OutRemedioDTO> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.deletar(id), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/inativar/{id}")
    @Transactional
    @Operation(summary = "Inativar Remédio!",
            description ="Inativar Remédio!",
            tags = {"Remedios"})
    public ResponseEntity<OutRemedioDTO> inativar(@PathVariable Long id){
        return new ResponseEntity<>(service.inativar(id), HttpStatus.OK);
    }

    @PutMapping("/ativar/{id}")
    @Transactional
    @Operation(summary = "Ativar Remédio!",
            description ="Ativar Remédio!",
            tags = {"Remedios"})
    public ResponseEntity<OutRemedioDTO> ativar(@PathVariable Long id){
        return new ResponseEntity<>(service.ativar(id), HttpStatus.OK);
    }
}

