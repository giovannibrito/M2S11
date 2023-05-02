package com.example.demo.repositories;

import com.example.demo.models.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta,Integer> {
}
