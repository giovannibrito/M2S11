package com.example.demo.repositories;

import com.example.demo.models.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta,Integer> {
    List<Pergunta> findByQuiz_Id(Integer id);
}
