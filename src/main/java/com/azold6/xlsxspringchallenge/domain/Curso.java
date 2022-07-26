package com.azold6.xlsxspringchallenge.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TB_CURSO")
public class Curso {

    @Column(name = "CD_CURSO")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME_CURSO")
    private String nomeCurso;

    @Column(name = "SG_CURSO")
    private String siglaCurso;

    @Column(name = "CD_CURSO")
    @OneToMany(mappedBy = "curso")
    private List<Aluno> aluno;

    @ManyToMany(mappedBy = "cursos")
    private List<Universidade> universidades;
}
