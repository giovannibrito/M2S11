package com.example.demo.controllers;

import com.example.demo.models.Quiz;
import com.example.demo.services.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService service;

    public QuizController(QuizService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Quiz> todosQuizzes(){
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public Quiz buscarQuiz(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

    @PostMapping()
    public Quiz criarQuiz(@RequestBody Quiz request){
        return service.criarQuiz(request);
    }

    @PutMapping("/{id}")
    public Quiz atualizarQuiz(@RequestBody Quiz request, @PathVariable Integer id){
        return service.atualizarQuiz(request, id);
    }

    @DeleteMapping("/{id}")
    public void excluirQuiz(@PathVariable Integer id){
        service.excluirQuiz(id);
    }
}
