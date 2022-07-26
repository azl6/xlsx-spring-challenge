package com.azold6.xlsxspringchallenge.domain;

import com.azold6.xlsxspringchallenge.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TB_ARQUIVO")
public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_ARQUIVO")
    private Integer id;

    @Column(name = "NOME_ARQUIVO")
    private String nomeArquivo;

    @Column(name = "URL_DIRETORIO")
    private String urlDiretorio;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS")
    private StatusEnum status;

}
