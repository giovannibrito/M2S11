package com.example.demo.repositories;

import com.example.demo.models.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta,Integer> {
    List<Resposta> findByPergunta_Id(Integer id);
}
