package com.api.eventos_sociales.model;

import java.util.Date;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
@SQLDelete(sql = "UPDATE local_galeria SET eliminado_en=now() WHERE id=?")
@Where(clause = "eliminado_en is null")
public class LocalGaleria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(table = "local")
    public int localId;
    private String foto;
    private Date creado_en = new Date();
    private Date eliminado_en;

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

    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getCreado_en() {
        return this.creado_en;
    }

    public void setCreado_en(Date creado_en) {
        this.creado_en = creado_en;
    }

    public Date getEliminado_en() {
        return this.eliminado_en;
    }

    public void setEliminado_en(Date eliminado_en) {
        this.eliminado_en = eliminado_en;
    }

}
