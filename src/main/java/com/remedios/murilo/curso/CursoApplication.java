package com.remedios.murilo.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}

}

// Spring Security
// Autenticação - para acessar a aplicação é necessário estar autenticado
// Autorização - Controle de acesso
// Proteção contra Ataques

// Autenticação com token - Input de Usuário e Senha, Validação no banco de dados se o usuário está cadastrado,
// retorna um token de acesso as funcionalidades da plataforma
