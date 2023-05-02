package com.example.demo.services;

import com.example.demo.models.Pergunta;
import com.example.demo.repositories.PerguntaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerguntaService {
    private final PerguntaRepository repository;

    public PerguntaService(PerguntaRepository repository) {
        this.repository = repository;
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
}
