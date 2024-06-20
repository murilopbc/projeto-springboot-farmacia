package com.remedios.murilo.curso.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authService;

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/login")
    @Operation(summary = "Fazer Login!",
            description ="Fazer Login!",
            tags = {"Auth"})
    public ResponseEntity<TokenJwtDTO> login(@RequestBody @Valid AuthenticationDTO dados){
        System.out.println("Print controller " + authService.loginAndCreateToken(dados));

        return new ResponseEntity<>(authService.loginAndCreateToken(dados), HttpStatus.OK);
    }

    @PostMapping("/register")
    @Operation(summary = "Cadastro!",
            description ="Cadastro!",
            tags = {"Auth"})
    public ResponseEntity<OutUsuarioDTO> register(@RequestBody @Valid InUsuarioDTO dados){
        return new ResponseEntity<>(authorizationService.register(dados), HttpStatus.OK);
    }
}
