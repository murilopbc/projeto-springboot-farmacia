package com.remedios.murilo.curso.dtos.remedios;

import com.remedios.murilo.curso.enums.Laboratorio;
import com.remedios.murilo.curso.enums.Via;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;


public record DadosCadastroRemedio(

        // Validations

        @NotBlank
        String nome,
        @Enumerated
        Via via, //Enum - já deixa as opções possíveis
        @NotBlank
        String lote,

        int quantidade,
        @Future
        LocalDate validade,
        @Enumerated
        Laboratorio laboratorio) {

}
