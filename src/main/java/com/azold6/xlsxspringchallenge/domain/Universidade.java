package com.azold6.xlsxspringchallenge.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "TB_UNIVERSIDADE_CURSO",
            joinColumns = @JoinColumn(name = "RF_UNIVERSIDADE"),
            inverseJoinColumns = @JoinColumn(name = "RF_CURSO"))
    private List<Curso> cursos;

    @JsonIgnore
    @OneToMany(mappedBy = "universidade")
    private List<Aluno> alunos = new ArrayList<>();
}
