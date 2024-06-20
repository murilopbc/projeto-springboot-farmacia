package com.remedios.murilo.curso.dtos.remedios;

import com.remedios.murilo.curso.enums.Laboratorio;
import com.remedios.murilo.curso.entities.Remedio;
import com.remedios.murilo.curso.enums.Via;

import java.time.LocalDate;

public record DadosListagemRemedio(String nome, Via via, String lote, Laboratorio laboratorio, LocalDate validade) {

    public DadosListagemRemedio(Remedio remedio) {
        this(remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getLaboratorio(), remedio.getValidade());
    }
}
