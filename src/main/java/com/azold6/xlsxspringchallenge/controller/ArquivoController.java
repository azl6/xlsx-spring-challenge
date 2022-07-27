package com.azold6.xlsxspringchallenge.controller;

import com.azold6.xlsxspringchallenge.domain.Aluno;
import com.azold6.xlsxspringchallenge.domain.Arquivo;
import com.azold6.xlsxspringchallenge.enums.StatusEnum;
import com.azold6.xlsxspringchallenge.repository.ArquivoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/arquivos")
@AllArgsConstructor
public class ArquivoController {

    private ArquivoRepository arquivoRepository;
    private static final String URL_DIRETORIO = "C:/Users/Alex/IdeaProjects/5 - Alex/xlsx-spring-challenge/arquivos/";

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {

        val arquivo = Arquivo.builder()
                                     .nomeArquivo(multipartFile.getOriginalFilename())
                                     .status(StatusEnum.AGUARDANDO_PROCESSAMENTO)
                                     .urlDiretorio(URL_DIRETORIO)
                                     .build();

        arquivoRepository.save(arquivo);
        multipartFile.transferTo(new File(URL_DIRETORIO + multipartFile.getOriginalFilename()));
        return ResponseEntity.status(HttpStatus.OK).body("Arquivo salvo com sucesso.");
    }
}
