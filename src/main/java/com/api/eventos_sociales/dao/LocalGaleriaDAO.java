package com.api.eventos_sociales.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.eventos_sociales.model.LocalGaleria;

@Repository
public interface LocalGaleriaDAO extends JpaRepository<LocalGaleria, Integer> {

    List<LocalGaleria> findByLocalId(int localId);
}
