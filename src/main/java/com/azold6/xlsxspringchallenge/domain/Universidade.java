package com.azold6.xlsxspringchallenge.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_UNIVERSIDADE")
public class Universidade {

    @Column(name = "CD_UNIVERSIDADE")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME_UNIVERSIDADE")
    private String nomeUniversidade;

    @Column(name = "SG_UNIVERSIDADE")
    private String siglaUniversidade;

    @ManyToMany
    @JoinTable(
            name = "TB_UNIVERSIDADE_CURSO",
            joinColumns = @JoinColumn(name = "RF_UNIVERSIDADE"),
            inverseJoinColumns = @JoinColumn(name = "RF_CURSO"))
    private List<Curso> cursos;
}
