package com.azold6.xlsxspringchallenge.repository;

import com.azold6.xlsxspringchallenge.domain.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Integer> {
}