package com.remedios.murilo.curso.controllers;


import com.remedios.murilo.curso.usuarios.DadosAutenticacao;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity<?> efetuarLogin (@RequestBody @Valid DadosAutenticacao dados){
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autenticacao = manager.authenticate(token);

        return ResponseEntity.ok().build();

    }
}
