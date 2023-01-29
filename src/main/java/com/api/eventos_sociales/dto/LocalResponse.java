package com.api.eventos_sociales.dto;

import java.util.List;

import com.api.eventos_sociales.model.Local;
import com.api.eventos_sociales.model.LocalGaleria;

public class LocalResponse {
    private Local local;
    private List<LocalGaleria> galeria;

    public Local getLocal() {
        return this.local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public List<LocalGaleria> getGaleria() {
        return this.galeria;
    }

    public void setGaleria(List<LocalGaleria> galeria) {
        this.galeria = galeria;
    }

}
