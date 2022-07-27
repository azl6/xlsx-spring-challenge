package com.azold6.xlsxspringchallenge.services;

import com.azold6.xlsxspringchallenge.domain.Aluno;
import com.azold6.xlsxspringchallenge.domain.Arquivo;
import com.azold6.xlsxspringchallenge.domain.Curso;
import com.azold6.xlsxspringchallenge.domain.Universidade;
import com.azold6.xlsxspringchallenge.enums.StatusEnum;
import com.azold6.xlsxspringchallenge.repository.AlunoRepository;
import com.azold6.xlsxspringchallenge.repository.ArquivoRepository;
import com.azold6.xlsxspringchallenge.repository.CursoRepository;
import com.azold6.xlsxspringchallenge.repository.UniversidadeRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
@AllArgsConstructor
public class ExcelService {

    private static final String URL_DIRETORIO = "C:/Users/Alex/IdeaProjects/5 - Alex/xlsx-spring-challenge/arquivos/";
    private ArquivoRepository arquivoRepository;
    private UniversidadeRepository universidadeRepository;
    private CursoRepository cursoRepository;
    private AlunoRepository alunoRepository;

    public void lerExcel(Arquivo arquivo) {

        List<Aluno> alunosLidos = new ArrayList<>();
        boolean isFirstRow = true;

        try {
            FileInputStream excelFile = new FileInputStream(new File(URL_DIRETORIO + arquivo.getNomeArquivo()));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                if(isFirstRow){
                    isFirstRow = false;
                    continue;
                }

                int iteracao = 0;
                Aluno tempAluno = new Aluno();

                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();

                    switch (iteracao){
                        case 0:
                            tempAluno.setMatricula((int) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            tempAluno.setDataMatricula(currentCell.getDateCellValue());
                            break;
                        case 2:
                            tempAluno.setNome(currentCell.getStringCellValue());
                            break;
                        case 3:
                            tempAluno.setN1(currentCell.getNumericCellValue());
                            break;
                        case 4:
                            tempAluno.setN2(currentCell.getNumericCellValue());
                            break;
                        case 5:
                            tempAluno.setN3(currentCell.getNumericCellValue());
                            break;
                        case 6:
                            tempAluno = this.processaUniversidade(tempAluno, currentCell.getStringCellValue());
                            break;
                        case 7:
                            tempAluno = this.processaCurso(tempAluno, currentCell.getStringCellValue());
                            break;
                    }
                    iteracao++;
                }
                tempAluno.setMedia((tempAluno.getN1() + tempAluno.getN2() + tempAluno.getN3()) / 3);
                alunosLidos.add(tempAluno);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        alunoRepository.saveAll(alunosLidos);
    }

    private Aluno processaUniversidade(Aluno aluno, String siglaUniversidade){
        val universidade = universidadeRepository.findBySiglaUniversidade(siglaUniversidade);

        if (universidade == null)
            throw new ObjectNotFoundException(1, "Universidade não encontrada.");

        aluno.setUniversidade(universidade);

        return aluno;

    }

    private Aluno processaCurso(Aluno aluno, String siglaCurso){
        val curso = cursoRepository.findBySiglaCurso(siglaCurso);

        if (curso == null)
            throw new ObjectNotFoundException(1, "Curso não encontrado.");

        aluno.setCurso(curso);

        return aluno;
    }
}
