package com.api.eventos_sociales.dto;

import com.api.eventos_sociales.model.Local;
import com.api.eventos_sociales.model.TipoEvento;

public class EventoFormData {
    private TipoEvento tipoEvento;
    private Local local;

    public TipoEvento getTipoEvento() {
        return this.tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Local getLocal() {
        return this.local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }


}

