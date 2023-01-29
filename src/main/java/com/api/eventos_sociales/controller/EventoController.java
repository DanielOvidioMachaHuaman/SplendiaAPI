package com.api.eventos_sociales.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.eventos_sociales.dao.EventoDAO;
import com.api.eventos_sociales.dao.LocalDAO;
import com.api.eventos_sociales.dao.LocalGaleriaDAO;
import com.api.eventos_sociales.dao.TipoEventoDAO;
import com.api.eventos_sociales.dao.UsuarioDAO;
import com.api.eventos_sociales.dto.EventoFormData;
import com.api.eventos_sociales.dto.EventoResponse;
import com.api.eventos_sociales.model.Evento;

@RestController
@RequestMapping("/evento")
@CrossOrigin(origins = "*")
public class EventoController {

    @Autowired
    private EventoDAO eventoDAO;
    @Autowired
    private LocalDAO localDAO;
    @Autowired
    private TipoEventoDAO tipoEventoDAO;
    @Autowired
    private LocalGaleriaDAO localGaleriaDAO;

    @Autowired
    private UsuarioDAO usuarioDAO;

    @GetMapping("loadFormData/{localId}/{tipoEventoId}")
    public EventoFormData loadFormData(@PathVariable("localId") int localId,
            @PathVariable("tipoEventoId") int tipoEventoId) {

        var eventoFormData = new EventoFormData();
        var _local = localDAO.findById(localId);
        var _tipoEvento = tipoEventoDAO.findById(tipoEventoId);

        if (_local.isPresent())
            eventoFormData.setLocal(_local.get());
        if (_tipoEvento.isPresent())
            eventoFormData.setTipoEvento(_tipoEvento.get());
        return eventoFormData;
    }

    @GetMapping()
    public List<EventoResponse> findAll() {

        var eventosResponse = new ArrayList<EventoResponse>();
        var eventos = eventoDAO.findAll();

        for (var evento : eventos) {
            var eventoResponse = new EventoResponse();
            var local = localDAO.findById(evento.getLocalId());
            var tipo_evento = tipoEventoDAO.findById(evento.getTipoEventoId());
            var usuario = usuarioDAO.findById(evento.getUsuarioId());

            eventoResponse.setEvento(evento);
            if (local.isPresent())
                eventoResponse.setLocal(local.get());
            if (tipo_evento.isPresent())
                eventoResponse.setTipoEvento(tipo_evento.get());
            if (usuario.isPresent())
                eventoResponse.setUsuario(usuario.get());

            eventosResponse.add(eventoResponse);
        }

        return eventosResponse;
    }

    @GetMapping("solicitudesAlquiler")
    public List<EventoResponse> solicitudesAlquiler() {

        var eventosResponse = new ArrayList<EventoResponse>();
        var eventos = eventoDAO.solicitudesAlquiler();

        for (var evento : eventos) {
            var eventoResponse = new EventoResponse();
            var local = localDAO.findById(evento.getLocalId());
            var tipo_evento = tipoEventoDAO.findById(evento.getTipoEventoId());
            var usuario = usuarioDAO.findById(evento.getUsuarioId());

            eventoResponse.setEvento(evento);
            if (local.isPresent())
                eventoResponse.setLocal(local.get());
            if (tipo_evento.isPresent())
                eventoResponse.setTipoEvento(tipo_evento.get());
            if (usuario.isPresent())
                eventoResponse.setUsuario(usuario.get());

            eventosResponse.add(eventoResponse);
        }

        return eventosResponse;
    }

    @GetMapping("eventos")
    public List<EventoResponse> eventos() {

        var eventosResponse = new ArrayList<EventoResponse>();
        var eventos = eventoDAO.eventos();

        for (var evento : eventos) {
            var eventoResponse = new EventoResponse();
            var local = localDAO.findById(evento.getLocalId());
            var tipo_evento = tipoEventoDAO.findById(evento.getTipoEventoId());
            var usuario = usuarioDAO.findById(evento.getUsuarioId());

            eventoResponse.setEvento(evento);
            if (local.isPresent())
                eventoResponse.setLocal(local.get());
            if (tipo_evento.isPresent())
                eventoResponse.setTipoEvento(tipo_evento.get());
            if (usuario.isPresent())
                eventoResponse.setUsuario(usuario.get());

            eventosResponse.add(eventoResponse);
        }

        return eventosResponse;
    }

    @GetMapping("/{id}")
    public EventoResponse findById(@PathVariable("id") int id) {

        var eventoResponse = new EventoResponse();
        var evento = eventoDAO.findById(id);
        if (evento.isPresent()) {

            var local = localDAO.findById(evento.get().getLocalId());
            var tipo_evento = tipoEventoDAO.findById(evento.get().getTipoEventoId());
            var usuario = usuarioDAO.findById(evento.get().getUsuarioId());
            
            eventoResponse.setEvento(evento.get());
            if (local.isPresent()){
                eventoResponse.setLocal(local.get());
                var galeria=localGaleriaDAO.findByLocalId(local.get().getId());
                eventoResponse.setFoto(galeria.isEmpty()?"":galeria.get(0).getFoto());

            }
            if (tipo_evento.isPresent())
                eventoResponse.setTipoEvento(tipo_evento.get());
            if (usuario.isPresent())
                eventoResponse.setUsuario(usuario.get());
        }
        return eventoResponse;
    }

    @PostMapping("marcarPagado/{id}")
    public Evento marcarPagado(@PathVariable("id") int id) {

        var evento = eventoDAO.findById(id);
        if (evento.isPresent()) {
            evento.get().setEstado("02");
            eventoDAO.save(evento.get());
        }
        return evento.get();
    }

    @PostMapping()
    public Evento save(@RequestBody Evento evento) {

        var _evento = new Evento();
        _evento.setLocalId(evento.getLocalId());
        _evento.setTipoEventoId(evento.getTipoEventoId());
        _evento.setUsuarioId(evento.getUsuarioId());
        _evento.setComentario(evento.getComentario());
        _evento.setFechaReserva(evento.getFechaReserva());
        _evento.setCreadoEn(new Date());
        _evento.setEstado("01");
        return eventoDAO.save(_evento);
    }
}
