package com.api.eventos_sociales.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class LocalTipoEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn
    private int localId;
    @JoinColumn
    private int tipoEventoId;
    private Date creadoEn;
    private Date eliminadoEn;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocalId() {
        return this.localId;
    }

    public void setLocalId(int local_id) {
        this.localId = local_id;
    }

    public int getTipoEventoId() {
        return this.tipoEventoId;
    }

    public void setTipoEventoId(int tipo_evento_id) {
        this.tipoEventoId = tipo_evento_id;
    }

    public Date getCreadoEn() {
        return this.creadoEn;
    }

    public void setCreadoEn(Date creado_en) {
        this.creadoEn = creado_en;
    }

    public Date getEliminadoEn() {
        return this.eliminadoEn;
    }

    public void setEliminadoEn(Date eliminado_en) {
        this.eliminadoEn = eliminado_en;
    }

}
