package com.azold6.xlsxspringchallenge.controller;

import com.azold6.xlsxspringchallenge.domain.Aluno;
import com.azold6.xlsxspringchallenge.services.AlunoService;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/alunos")
@AllArgsConstructor
public class AlunoController {

    AlunoService alunoService;

    @GetMapping
    public ResponseEntity<Page<Aluno>> findAllByPageable(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "2") Integer size,
            @RequestParam(required = false, defaultValue = "nome") String sortBy,
            @RequestParam(required = false, defaultValue = "ASC") String direction){

        val response =
                alunoService.findAllByPageable(
                PageRequest.of(page,
                               size,
                               Sort.by(
                                       Objects.equals(direction, "ASC") ?
                                               Sort.Direction.ASC :
                                               Sort.Direction.DESC, sortBy)));

        return ResponseEntity.ok(response);
    }
}
