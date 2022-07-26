package com.azold6.xlsxspringchallenge.repository;

import com.azold6.xlsxspringchallenge.domain.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM TB_ARQUIVO ar WHERE ar.STATUS = 'AGUARDANDO_PROCESSAMENTO'")
    public List<Arquivo> findAllAguardandoProcessamento();
}
