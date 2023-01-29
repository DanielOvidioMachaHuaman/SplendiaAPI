package com.api.eventos_sociales.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TipoEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private Date creadoEn;
    private Date eliminadoEn;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
