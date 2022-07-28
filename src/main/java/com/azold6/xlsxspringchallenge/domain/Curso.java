package com.azold6.xlsxspringchallenge.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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

    @JsonIgnore
    @Column(name = "CD_CURSO")
    @OneToMany(mappedBy = "curso")
    private List<Aluno> aluno;

    @JsonIgnore
    @ManyToMany(mappedBy = "cursos")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Universidade> universidades;
}
