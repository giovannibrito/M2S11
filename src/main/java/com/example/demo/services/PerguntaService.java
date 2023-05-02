package com.example.demo.services;

import com.example.demo.dtos.PerguntaDto;
import com.example.demo.mappers.PerguntaMapper;
import com.example.demo.models.Pergunta;
import com.example.demo.repositories.PerguntaRepository;
import com.example.demo.repositories.QuizRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerguntaService {
    private final PerguntaRepository repository;
    private final QuizRepository quizRepository;
    private final PerguntaMapper mapper;

    public PerguntaService(PerguntaRepository repository,QuizRepository quizRepository, PerguntaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.quizRepository = quizRepository;
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

    public Pergunta atualizarPergunta(PerguntaDto request, Integer id) {
        Pergunta pergunta = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (request.getTitulo() != null && request.getTitulo().length() > 0){
            pergunta.setTitulo(request.getTitulo());
        }
        if (request.getTexto() != null && request.getTexto().length() > 0){
            pergunta.setTexto(request.getTexto());
        }
        if (request.getQuiz_id() != null && quizRepository.findById(request.getQuiz_id()).isPresent()){
            pergunta.setQuiz(quizRepository.findById(request.getQuiz_id()).get());
        }
        return repository.save(pergunta);
    }
}
