package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String texto;
    @ManyToOne
    private Pergunta pergunta;
}
