package com.example.demo.mappers;

import com.example.demo.dtos.RespostaDto;
import com.example.demo.models.Resposta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RespostaMapper {
    @Mapping(target = "pergunta.id", source = "pergunta_id")
    Resposta map(RespostaDto dto);
    @Mapping(target = "pergunta_id", source = "pergunta.id")
    RespostaDto map(Resposta resposta);
}
