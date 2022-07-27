package com.azold6.xlsxspringchallenge.mappers;

import com.azold6.xlsxspringchallenge.domain.Curso;
import com.azold6.xlsxspringchallenge.domain.Universidade;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;

public class BaseMapper {

    protected Converter<Curso, String> cursoConverter(){
        return new AbstractConverter<Curso, String>() {
            @Override
            protected String convert(Curso curso) {
                return curso.getNomeCurso();
            }
        };
    }

    protected Converter<Universidade, String> universidadeConverter(){
        return new AbstractConverter<Universidade, String>() {
            @Override
            protected String convert(Universidade curso) {
                return curso.getNomeUniversidade();
            }
        };
    }

}
