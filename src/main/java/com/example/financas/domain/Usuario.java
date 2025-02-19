package com.example.financas.domain;

import com.example.financas.domain.enums.UsuarioRole;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private UsuarioRole role;

    @OneToMany(mappedBy = "usuario")
    private List<Transacao> transacoes;
    public Usuario(){

    }

    public Usuario(Long id, String nome, String email, String senha, UsuarioRole role, List<Transacao> transacoes) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
        this.transacoes = transacoes;
    }
}
