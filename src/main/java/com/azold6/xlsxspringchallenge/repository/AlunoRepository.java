package com.azold6.xlsxspringchallenge.repository;

import com.azold6.xlsxspringchallenge.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
