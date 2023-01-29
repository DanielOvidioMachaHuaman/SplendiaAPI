package com.api.eventos_sociales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.eventos_sociales.model.LocalTipoEvento;

@Repository
public interface LocalTipoEventoDAO extends JpaRepository<LocalTipoEvento, Integer> {
}
