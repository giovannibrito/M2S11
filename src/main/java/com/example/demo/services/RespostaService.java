package com.example.demo.services;

import com.example.demo.dtos.RespostaDto;
import com.example.demo.mappers.RespostaMapper;
import com.example.demo.models.Resposta;
import com.example.demo.repositories.RespostaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaService {
    private final RespostaRepository repository;
    private final RespostaMapper mapper;

    public RespostaService(RespostaRepository repository, RespostaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Resposta> buscarTodas() {
        return repository.findAll();
    }

    public Resposta buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Resposta> buscarPorPergunta(Integer pergunta) {
        return repository.findByPergunta_Id(pergunta);
    }

    public Resposta criarResposta(RespostaDto request) {
       return repository.save(mapper.map(request));
    }
}
