package com.api.eventos_sociales.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.eventos_sociales.dto.LocalItem;
import com.api.eventos_sociales.model.Local;

@Repository
public interface LocalDAO extends JpaRepository<Local, Integer> {

    // List<Local> findByParaCumpleanosTrue();
    @Query(nativeQuery = true, value = "select id,nombre,descripcion,precio,(select foto from local_galeria where local_id = l.id limit 1) foto from local l where para_cumpleanos=true and eliminado_en is null;")
    List<LocalItem> findByParaCumpleanosTrue();
    @Query(nativeQuery = true, value = "select id,nombre,descripcion,precio,(select foto from local_galeria where local_id = l.id limit 1) foto from local l where para_eventos_corporativos=true and eliminado_en is null;")
    List<LocalItem> findByParaEventosCorporativosTrue();
    @Query(nativeQuery = true, value = "select id,nombre,descripcion,precio,(select foto from local_galeria where local_id = l.id limit 1) foto from local l where para_fiestas_infantiles=true and eliminado_en is null;")
    List<LocalItem> findByParaFiestasInfantilesTrue();
    @Query(nativeQuery = true, value = "select id,nombre,descripcion,precio,(select foto from local_galeria where local_id = l.id limit 1) foto from local l where para_matrimonios=true and eliminado_en is null;")
    List<LocalItem> findByParaMatrimoniosTrue();
}
