package com.exercise.stategies.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="simulador")
public class Simulador {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Accion> accionesCargadas = new ArrayList<>();

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Accion> accionesCompradas = new ArrayList<>();

    @Column(name="fechaDesde")
    private LocalDate fechaDesde;

    @Column(name="fechaHasta")
    private LocalDate fechaHasta;

    @Column(name="montoInicial")
    private float montoInicial;

    @Column(name="montoActual")
    private float montoActual;

    public Simulador() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAccionesCargadas(List<Accion> accionesCargadas) {
        this.accionesCargadas = accionesCargadas;
    }

    public void setAccionesCompradas(List<Accion> accionesCompradas) {
        this.accionesCompradas = accionesCompradas;
    }

    public List<Accion> getAccionesCargadas() {
        return accionesCargadas;
    }

    public List<Accion> getAccionesCompradas() {
        return accionesCompradas;
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
