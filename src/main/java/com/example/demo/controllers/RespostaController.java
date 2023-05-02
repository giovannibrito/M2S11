package com.example.demo.controllers;

import com.example.demo.models.Resposta;
import com.example.demo.services.RespostaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resposta")
public class RespostaController {
    private final RespostaService service;

    public RespostaController(RespostaService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Resposta> todasRespostas(){
        return service.buscarTodas();
    }

    @GetMapping("/{id}")
    public Resposta buscarResposta(@PathVariable Integer id){
        return service.buscarPorId(id);
    }
}
