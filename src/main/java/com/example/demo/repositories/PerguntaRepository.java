package com.example.demo.repositories;

import com.example.demo.models.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerguntaRepository extends JpaRepository<Pergunta,Integer> {
}
