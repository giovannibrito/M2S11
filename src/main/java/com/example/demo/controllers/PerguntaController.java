package com.example.demo.controllers;

import com.example.demo.models.Pergunta;
import com.example.demo.services.PerguntaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pergunta")
public class PerguntaController {
    private final PerguntaService service;

    public PerguntaController(PerguntaService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Pergunta> todasPerguntas(){
        return service.buscarTodas();
    }

    @GetMapping("/{id}")
    public Pergunta buscarPergunta(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

}
