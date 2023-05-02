package com.example.demo.services;

import com.example.demo.dtos.RespostaDto;
import com.example.demo.mappers.RespostaMapper;
import com.example.demo.models.Pergunta;
import com.example.demo.models.Resposta;
import com.example.demo.repositories.PerguntaRepository;
import com.example.demo.repositories.RespostaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaService {
    private final RespostaRepository repository;
    private final PerguntaRepository perguntaRepository;
    private final RespostaMapper mapper;

    public RespostaService(RespostaRepository repository, PerguntaRepository perguntaRepository, RespostaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.perguntaRepository = perguntaRepository;
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

    public Resposta atualizarResposta(RespostaDto request, Integer id) {
        Resposta resposta = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (request.getTexto() != null && request.getTexto().length() > 0){
            resposta.setTexto(request.getTexto());
        }
        if (request.getPergunta_id() != null && perguntaRepository.findById(request.getPergunta_id()).isPresent()){
            resposta.setPergunta(perguntaRepository.findById(request.getPergunta_id()).get());
        }
        return repository.save(resposta);

    }
}
