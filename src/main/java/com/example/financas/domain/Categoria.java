package com.example.financas.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Transacao> transacoes;

    public Categoria() {

    }

    public Categoria(Long id, String nome, String descricao, List<Transacao> transacoes) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.transacoes = transacoes;
    }
}