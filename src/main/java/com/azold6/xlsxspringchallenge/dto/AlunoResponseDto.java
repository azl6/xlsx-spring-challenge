package com.azold6.xlsxspringchallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AlunoResponseDto {

    private Integer matricula;
    private Date dataMatricula;
    private String nome;
    private Double media;
    private String curso;
    private String universidade;
}
