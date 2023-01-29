package com.api.eventos_sociales.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int aforo;
    private String dimensiones;
    private String estado;
    private Double precio;
    private int calificacion;
    private String descripcion;
    private String ubicacion;
    private Date creado_en;
    private Date eliminadoEn;
    private Boolean paraCumpleanos;
    private Boolean paraEventosCorporativos;
    private Boolean paraMatrimonios;
    private Boolean paraFiestasInfantiles;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    public int getAforo() {
        return this.aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public String getDimensiones() {
        return this.dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCalificacion() {
        return this.calificacion;
    }

    public void setCalificacion(int clasificacion) {
        this.calificacion = clasificacion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getCreado_en() {
        return this.creado_en;
    }

    public void setCreado_en(Date creado_en) {
        this.creado_en = creado_en;
    }

    public Date getEliminadoEn() {
        return this.eliminadoEn;
    }

    public void setEliminadoEn(Date eliminadoEn) {
        this.eliminadoEn = eliminadoEn;
    }

    public Boolean isParaCumpleanos() {
        return this.paraCumpleanos;
    }

    public Boolean getParaCumpleanos() {
        return this.paraCumpleanos;
    }

    public void setParaCumpleanos(Boolean paraCumpleanos) {
        this.paraCumpleanos = paraCumpleanos;
    }

    public Boolean isParaEventosCorporativos() {
        return this.paraEventosCorporativos;
    }

    public Boolean getParaEventosCorporativos() {
        return this.paraEventosCorporativos;
    }

    public void setParaEventosCorporativos(Boolean paraEventosCorporativos) {
        this.paraEventosCorporativos = paraEventosCorporativos;
    }

    public Boolean isParaMatrimonios() {
        return this.paraMatrimonios;
    }

    public Boolean getParaMatrimonios() {
        return this.paraMatrimonios;
    }

    public void setParaMatrimonios(Boolean paraMatrimonios) {
        this.paraMatrimonios = paraMatrimonios;
    }

    public Boolean isParaFiestasInfantiles() {
        return this.paraFiestasInfantiles;
    }

    public Boolean getParaFiestasInfantiles() {
        return this.paraFiestasInfantiles;
    }

    public void setParaFiestasInfantiles(Boolean paraFiestasInfantiles) {
        this.paraFiestasInfantiles = paraFiestasInfantiles;
    }
}