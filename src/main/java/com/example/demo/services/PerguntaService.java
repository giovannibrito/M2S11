package com.example.demo.services;

import com.example.demo.dtos.PerguntaDto;
import com.example.demo.mappers.PerguntaMapper;
import com.example.demo.models.Pergunta;
import com.example.demo.repositories.PerguntaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerguntaService {
    private final PerguntaRepository repository;
    private final PerguntaMapper mapper;

    public PerguntaService(PerguntaRepository repository, PerguntaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Pergunta> buscarTodas() {
        return repository.findAll();
    }

    public Pergunta buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Pergunta> buscarPorQuiz(Integer quiz) {
        return repository.findByQuiz_Id(quiz);
    }

    public Pergunta criarPergunta(PerguntaDto request) {
        return repository.save(mapper.map(request));
    }
}
