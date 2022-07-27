package com.azold6.xlsxspringchallenge.services;

import com.azold6.xlsxspringchallenge.domain.Aluno;
import com.azold6.xlsxspringchallenge.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlunoService {

    private AlunoRepository alunoRepository;

    public Page<Aluno> findAllByPageable(Pageable pageable){
        return alunoRepository.findAll(pageable);
    }
}
