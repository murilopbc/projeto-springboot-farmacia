package com.remedios.murilo.curso.remedio.dtos;

import com.remedios.murilo.curso.remedio.enums.Laboratorio;
import com.remedios.murilo.curso.remedio.Remedio;
import com.remedios.murilo.curso.remedio.enums.Via;

import java.time.LocalDate;

public record DadosListagemRemedio(String nome, Via via, String lote, Laboratorio laboratorio, LocalDate validade) {

    public DadosListagemRemedio(Remedio remedio) {
        this(remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getLaboratorio(), remedio.getValidade());
    }
}
