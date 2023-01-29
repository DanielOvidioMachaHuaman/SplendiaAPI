package com.api.eventos_sociales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.eventos_sociales.model.TipoEvento;

@Repository
public interface TipoEventoDAO extends JpaRepository<TipoEvento, Integer> {
}
