package com.azold6.xlsxspringchallenge.services;

import com.azold6.xlsxspringchallenge.domain.Arquivo;
import com.azold6.xlsxspringchallenge.enums.StatusEnum;
import com.azold6.xlsxspringchallenge.repository.ArquivoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class ProcessamentoJob {

    private ArquivoRepository arquivoRepository;
    private ExcelService excelService;

    @Scheduled(cron = "*/10 * * * * *")
    @Transactional(propagation= Propagation.REQUIRED, noRollbackFor=Exception.class)
    public void processa(){
        log.info("Iniciando processamento...");
        List<Arquivo> arquivos = arquivoRepository.findAllAguardandoProcessamento();

        if(arquivos.isEmpty()){
            log.info("Não foram encontrados arquivos. Abortando...");
            return;
        }

        arquivos.forEach(arq -> {
            excelService.lerExcel(arq);
            arq.setStatus(StatusEnum.PROCESSADO);
            arquivoRepository.save(arq);
        });

        log.info("Finalizando processamento...");
    }
}
