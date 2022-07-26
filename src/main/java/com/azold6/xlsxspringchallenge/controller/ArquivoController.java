package com.azold6.xlsxspringchallenge.controller;

import com.azold6.xlsxspringchallenge.domain.Arquivo;
import com.azold6.xlsxspringchallenge.enums.StatusEnum;
import com.azold6.xlsxspringchallenge.repository.ArquivoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
@AllArgsConstructor
public class ArquivoController {

    private ArquivoRepository arquivoRepository;

    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        val arquivo = Arquivo.builder()
                                        .nomeArquivo(file.getOriginalFilename())
                                        .status(StatusEnum.AGUARDANDO_PROCESSAMENTO)
                                        .urlDiretorio("/arquivos/")
                                        .build();

        arquivoRepository.save(arquivo);
        return ResponseEntity.status(HttpStatus.OK).body("Arquivo salvo com sucesso.");
    }
}
