package com.azold6.xlsxspringchallenge.repository;

import com.azold6.xlsxspringchallenge.domain.Curso;
import com.azold6.xlsxspringchallenge.domain.Universidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

    @Query(nativeQuery = true, value = "SELECT DISTINCT * FROM TB_CURSO tc WHERE tc.SG_CURSO = ?1")
    Curso findBySiglaCurso(String siglaCurso);
}
