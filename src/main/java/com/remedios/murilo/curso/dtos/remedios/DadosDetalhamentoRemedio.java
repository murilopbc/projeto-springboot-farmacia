package com.remedios.murilo.curso.dtos.remedios;

import com.remedios.murilo.curso.entities.Remedio;
import com.remedios.murilo.curso.enums.Laboratorio;
import com.remedios.murilo.curso.enums.Via;

import java.time.LocalDate;

public record DadosDetalhamentoRemedio(Long id,
                                       String nome,
                                       Via via,
                                       String lote,
                                       int quantidade,
                                       LocalDate validade,
                                       Laboratorio laboratorio,
                                       Boolean ativo) {

    public DadosDetalhamentoRemedio(Remedio remedio){
        this(
                remedio.getId(),
                remedio.getNome(),
                remedio.getVia(),
                remedio.getLote(),
                remedio.getQuantidade(),
                remedio.getValidade(),
                remedio.getLaboratorio(),
                remedio.getAtivo());
    }
}
