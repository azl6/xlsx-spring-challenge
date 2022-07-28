package com.azold6.xlsxspringchallenge.repository;

import com.azold6.xlsxspringchallenge.domain.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    @Query("FROM Aluno a WHERE a.curso.id = ?1 AND a.universidade.id = ?2")
    Page<Aluno> findAllBy(Integer cursoId, Integer universidadeId, Pageable pageable);
}
