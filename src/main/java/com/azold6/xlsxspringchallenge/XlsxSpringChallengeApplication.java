package com.azold6.xlsxspringchallenge;

import com.azold6.xlsxspringchallenge.domain.Curso;
import com.azold6.xlsxspringchallenge.domain.Universidade;
import com.azold6.xlsxspringchallenge.repository.CursoRepository;
import com.azold6.xlsxspringchallenge.repository.UniversidadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
@EnableScheduling
@AllArgsConstructor
public class XlsxSpringChallengeApplication implements CommandLineRunner {

	private UniversidadeRepository universidadeRepository;
	private CursoRepository cursoRepository;

	public static void main(String[] args) {
		SpringApplication.run(XlsxSpringChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Universidade unifei = Universidade.builder()
							  .nomeUniversidade("Universidade Federal de Itajubá")
							  .siglaUniversidade("UNIFEI")
							  .build();

		Universidade fepi = Universidade.builder()
							.nomeUniversidade("Centro Universitário de Itajubá")
							.siglaUniversidade("FEPI")
							.build();

		Universidade ifsuldeminas = Universidade.builder()
									.nomeUniversidade("Instituto Federal de Educação, Ciência e Tecnologia do Sul de Minas Gerais")
									.siglaUniversidade("IFSULDEMINAS")
									.build();

		Curso sin = Curso.builder()
					.nomeCurso("Sistemas de informação")
					.siglaCurso("SIN")
					.universidades(List.of(unifei, fepi, ifsuldeminas))
					.build();

		Curso eco = Curso.builder()
					.nomeCurso("Engenharia da computação")
					.siglaCurso("ECO")
					.universidades(List.of(unifei, fepi, ifsuldeminas))
					.build();

		Curso mat = Curso.builder()
					.nomeCurso("Matemática")
					.siglaCurso("MAT")
					.universidades(List.of(unifei, fepi, ifsuldeminas))
					.build();

		cursoRepository.saveAll(List.of(sin, eco, mat));

		unifei.setCursos(List.of(sin, eco, mat));
		fepi.setCursos(List.of(sin, eco, mat));
		ifsuldeminas.setCursos(List.of(sin, eco, mat));

		universidadeRepository.saveAll(List.of(unifei, fepi, ifsuldeminas));


	}
}
