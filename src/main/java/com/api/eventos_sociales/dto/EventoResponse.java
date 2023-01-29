package com.api.eventos_sociales.dto;

import com.api.eventos_sociales.model.Evento;
import com.api.eventos_sociales.model.Local;
import com.api.eventos_sociales.model.TipoEvento;
import com.api.eventos_sociales.model.Usuario;

public class EventoResponse {
    private String foto;
    private Evento evento;
    private Local local;
    private TipoEvento tipoEvento;
    private Usuario usuario;

    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Evento getEvento() {
        return this.evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Local getLocal() {
        return this.local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public TipoEvento getTipoEvento() {
        return this.tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
