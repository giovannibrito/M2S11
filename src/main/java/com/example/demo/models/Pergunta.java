package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String texto;
    @ManyToOne
    private Quiz quiz;
}