package com.example.demo.controllers;

import com.example.demo.dtos.PerguntaDto;
import com.example.demo.models.Pergunta;
import com.example.demo.services.PerguntaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pergunta")
public class PerguntaController {
    private final PerguntaService service;

    public PerguntaController(PerguntaService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Pergunta> todasPerguntas(@RequestParam(required = false) Integer quiz){
        if (quiz != null) {
            return service.buscarPorQuiz(quiz);
        }
        return service.buscarTodas();
    }

    @GetMapping("/{id}")
    public Pergunta buscarPergunta(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

    @PostMapping()
    public Pergunta criarPergunta(@RequestBody PerguntaDto request){
        return service.criarPergunta(request);
    }

    @PutMapping("/{id}")
    public Pergunta atualizarPergunta(@RequestBody PerguntaDto request, @PathVariable Integer id){
        return service.atualizarPergunta(request,id);
    }
}
