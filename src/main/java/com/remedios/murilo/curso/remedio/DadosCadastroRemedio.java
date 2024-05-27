package com.remedios.murilo.curso.remedio;

public record DadosCadastroRemedio(
        String nome,
        Via via, //Enum - já deixa as opções possíveis
        String lote,
        String quantidade,
        String validade,
        Laboratorio laboratorio) {

}
