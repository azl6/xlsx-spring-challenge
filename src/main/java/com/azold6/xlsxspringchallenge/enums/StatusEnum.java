package com.azold6.xlsxspringchallenge.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum StatusEnum {

    AGUARDANDO_PROCESSAMENTO(1, "Aguardando processamento"),
    PROCESSADO(2, "Processado");

    private Integer codigo;
    private String descricao;
}
