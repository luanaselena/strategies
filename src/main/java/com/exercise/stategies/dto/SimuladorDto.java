package com.exercise.stategies.dto;

import com.exercise.stategies.entities.Accion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SimuladorDto {

    private Integer id;
    private List<Accion> accionesCargadas = new ArrayList<>();
    private List<Accion> accionesCompradas = new ArrayList<>();
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private float montoInicial;
    private float montoActual;

    public SimuladorDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Accion> getAccionesCargadas() {
        return accionesCargadas;
    }

    public void setAccionesCargadas(List<Accion> accionesCargadas) {
        this.accionesCargadas = accionesCargadas;
    }

    public List<Accion> getAccionesCompradas() {
        return accionesCompradas;
    }

    public void setAccionesCompradas(List<Accion> accionesCompradas) {
        this.accionesCompradas = accionesCompradas;
    }

    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public float getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(float montoInicial) {
        this.montoInicial = montoInicial;
    }

    public float getMontoActual() {
        return montoActual;
    }

    public void setMontoActual(float montoActual) {
        this.montoActual = montoActual;
    }
}
