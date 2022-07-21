package com.azold6.xlsxspringchallenge.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_ALUNO")
public class Aluno {

    @Column(name = "CD_ALUNO")
    @Id
    private String matricula;

    @Column(name = "DATA_MATRICULA")
    private Date dataMatricula;

    @Column(name = "NOME_ALUNO")
    private String nome;

    @Column(name = "NOTA_1")
    private Double n1;

    @Column(name = "NOTA_2")
    private Double n2;

    @Column(name = "NOTA_3")
    private Double n3;

    @ManyToOne
    @JoinColumn(name = "RF_CURSO", referencedColumnName = "CD_CURSO")
    private Curso curso;
}
