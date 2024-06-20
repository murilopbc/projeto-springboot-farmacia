package com.remedios.murilo.curso.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    @Operation(summary = "Buscar Usuários!",
            description ="Buscar Usuários!",
            tags = {"Usuários"})
    public ResponseEntity<List<OutUsuarioDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/inativar/{id}")
    @Transactional
    @Operation(summary = "Inativar Usuário!",
            description ="Inativar Usuário!!",
            tags = {"Usuários"})
    public ResponseEntity<OutUsuarioDTO> inativar(@PathVariable Long id){
        return new ResponseEntity<>(service.inativar(id), HttpStatus.OK);
    }

    @PutMapping("/ativar/{id}")
    @Transactional
    @Operation(summary = "Ativar Usuário!",
            description ="Ativar Usuário!!",
            tags = {"Usuários"})
    public ResponseEntity<OutUsuarioDTO> ativar (@PathVariable Long id){
        return new ResponseEntity<>(service.ativar(id), HttpStatus.OK);
    }

    @PutMapping("/privilege/{id}")
    @Transactional
    @Operation(summary = "Setar Roles!",
            description ="Setar Roles!",
            tags = {"Usuários"})
    public ResponseEntity<OutUsuarioDTO> privilege (@PathVariable Long id, @RequestBody @Valid PrivilegeDTO dados){
        return new ResponseEntity<>(service.setPrivilege(id, dados.role()), HttpStatus.OK);
    }
}
