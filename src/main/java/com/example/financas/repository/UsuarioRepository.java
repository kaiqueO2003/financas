package com.example.financas.repository;

import com.example.financas.domain.Categoria;
import com.example.financas.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
