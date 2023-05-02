package com.example.demo.mappers;

import com.example.demo.dtos.PerguntaDto;
import com.example.demo.models.Pergunta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PerguntaMapper {
    @Mapping(target = "quiz.id", source = "quiz_id")
    Pergunta map(PerguntaDto dto);
    @Mapping(target = "quiz_id", source = "quiz.id")
    PerguntaDto map(Pergunta pergunta);
}
