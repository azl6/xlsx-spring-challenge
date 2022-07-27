package com.azold6.xlsxspringchallenge.mappers;

import com.azold6.xlsxspringchallenge.domain.Aluno;
import com.azold6.xlsxspringchallenge.dto.AlunoResponseDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AlunoMapper extends BaseMapper{

    ModelMapper modelMapper;

    public AlunoResponseDto domainToResponseDto(Aluno aluno){
        TypeMap<Aluno, AlunoResponseDto> typeMap = modelMapper.getTypeMap(Aluno.class, AlunoResponseDto.class);

        if(typeMap == null)
            typeMap = modelMapper.createTypeMap(Aluno.class, AlunoResponseDto.class);

        typeMap.addMappings(mapper -> mapper.using(super.cursoConverter()).map(Aluno::getCurso, AlunoResponseDto::setCurso));
        typeMap.addMappings(mapper -> mapper.using(super.universidadeConverter()).map(Aluno::getUniversidade, AlunoResponseDto::setUniversidade));

        AlunoResponseDto response = modelMapper.map(aluno, AlunoResponseDto.class);
        response.setMedia((aluno.getN1() + aluno.getN2() + aluno.getN3()) / 3);
        return response;
    }
}
