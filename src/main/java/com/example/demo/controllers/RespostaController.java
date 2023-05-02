package com.example.demo.controllers;

import com.example.demo.dtos.RespostaDto;
import com.example.demo.models.Resposta;
import com.example.demo.services.RespostaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resposta")
public class RespostaController {
    private final RespostaService service;

    public RespostaController(RespostaService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Resposta> todasRespostas(@RequestParam(required = false) Integer pergunta){
        if(pergunta != null){
            return service.buscarPorPergunta(pergunta);
        }
        return service.buscarTodas();
    }

    @GetMapping("/{id}")
    public Resposta buscarResposta(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

    @PostMapping()
    public Resposta criarResposta(@RequestBody RespostaDto request){
        return service.criarResposta(request);
    }
}
