package com.exercise.stategies.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="reporte")
public class Reporte {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="accionMasComprada")
    private String accionMasComprada;

    @Column(name="accionMasGanancia")
    private String accionMasGanancia;

    @Column(name="diasProcesados")
    private long diasProcesados;

    @Column(name="lucro")
    private float lucro;

    @Column(name="cantComprasTotales")
    private int cantComprasTotales;

    @Column(name="cantComprasConGanancia")
    private int cantComprasConGanancia;

    public Reporte() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccionMasCompradas() {
        return accionMasComprada;
    }

    public void setAccionMasCompradas(String accionMasCompradas) {
        this.accionMasComprada = accionMasCompradas;
    }

    public String getAccionMasGanancia() {
        return accionMasGanancia;
    }

    public void setAccionesMasGanancia(String accionMasGanancia) {
        this.accionMasGanancia = accionMasGanancia;
    }

    public long getDiasProcesados() {
        return diasProcesados;
    }

    public void setDiasProcesados(long diasProcesados) {
        this.diasProcesados = diasProcesados;
    }

    public float getLucro() {
        return lucro;
    }

    public void setLucro(float lucro) {
        this.lucro = lucro;
    }

    public int getCantComprasTotales() {
        return cantComprasTotales;
    }

    public void setCantComprasTotales(int cantComprasTotales) {
        this.cantComprasTotales = cantComprasTotales;
    }

    public int getCantComprasConGanancia() {
        return cantComprasConGanancia;
    }

    public void setCantComprasConGanancia(int cantComprasConGanancia) {
        this.cantComprasConGanancia = cantComprasConGanancia;
    }
}
