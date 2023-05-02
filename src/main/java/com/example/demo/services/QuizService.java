package com.example.demo.services;

import com.example.demo.models.Quiz;
import com.example.demo.repositories.QuizRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    private final QuizRepository repository;

    public QuizService(QuizRepository repository) {
        this.repository = repository;
    }

    public List<Quiz> buscarTodos() {
        return repository.findAll();
    }

    public Quiz buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Quiz criarQuiz(Quiz request) {
        return repository.save(request);
    }

    public Quiz atualizarQuiz(Quiz request, Integer id) {
        Quiz quiz = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (request.getNome() != null && request.getNome().length() > 0){
            quiz.setNome(request.getNome());
        }
        if (request.getDescricao() != null && request.getDescricao().length() > 0){
            quiz.setDescricao(request.getDescricao());
        }
        return repository.save(quiz);
    }

    public void excluirQuiz(Integer id) {
        repository.deleteById(id);
    }
}
