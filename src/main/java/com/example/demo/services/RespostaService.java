package com.example.demo.services;

import com.example.demo.models.Resposta;
import com.example.demo.repositories.RespostaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaService {
    private final RespostaRepository repository;

    public RespostaService(RespostaRepository repository) {
        this.repository = repository;
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
}
