package com.api.eventos_sociales.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.eventos_sociales.model.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {


    List<Usuario> findByUsuario(String usuario);
}
