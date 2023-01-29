package com.api.eventos_sociales.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.eventos_sociales.dto.EventoItem;
import com.api.eventos_sociales.model.Evento;

@Repository
public interface EventoDAO extends JpaRepository<Evento, Integer> {

    @Query(nativeQuery = true, value = "select e.id as id,e.comentario as comentario from evento e where id=1")
    EventoItem getEventoItem(int id);


    @Query(nativeQuery = true, value = "select e.* from evento e where estado='01'")
    List<Evento> solicitudesAlquiler();


    @Query(nativeQuery = true, value = "select e.* from evento e where estado<>'01'")
    List<Evento> eventos();
}
