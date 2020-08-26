package com.exercise.stategies.dto;

import com.exercise.stategies.entities.Accion;

import java.util.ArrayList;
import java.util.List;

public class ReporteDto {

    private Integer id;
    private String accionMasCompradas;
    private String accionMasGanancia;
    private long diasProcesados;
    private float lucro;
    private int cantComprasTotales;
    private int cantComprasConGanancia;

    public ReporteDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccionMasCompradas() {
        return accionMasCompradas;
    }

    public void setAccionMasCompradas(String accionMasCompradas) {
        this.accionMasCompradas = accionMasCompradas;
    }

    public String getAccionMasGanancia() {
        return accionMasGanancia;
    }

    public void setAccionMasGanancia(String accionMasGanancia) {
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
