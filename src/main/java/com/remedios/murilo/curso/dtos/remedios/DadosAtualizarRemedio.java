package com.remedios.murilo.curso.dtos.remedios;

import com.remedios.murilo.curso.enums.Laboratorio;
import com.remedios.murilo.curso.enums.Via;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRemedio(
        @NotNull
        Long id,
        String nome,
        Via via,
        Laboratorio laboratorio) {

}
