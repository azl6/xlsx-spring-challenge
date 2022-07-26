package com.azold6.xlsxspringchallenge.repository;

import com.azold6.xlsxspringchallenge.domain.Universidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversidadeRepository extends JpaRepository<Universidade, Integer> {
    Universidade findBySiglaUniversidade(String siglaUniversidade);
}
