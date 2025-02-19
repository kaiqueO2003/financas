package com.example.financas.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorTransacao;
    private LocalDate data;
    private String descricao;
    private String status;
    private String tipo;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Usuario usuario;

    public Transacao(){

    }

    public Transacao(Long id, Double valorTransacao, LocalDate data, String descricao, String status, String tipo, Categoria categoria, Usuario usuario) {
        this.id = id;
        this.valorTransacao = valorTransacao;
        this.data = data;
        this.descricao = descricao;
        this.status = status;
        this.tipo = tipo;
        this.categoria = categoria;
        this.usuario = usuario;
    }
}
