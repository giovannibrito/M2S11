package com.example.demo.controllers;

import com.example.demo.models.Quiz;
import com.example.demo.services.QuizService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
