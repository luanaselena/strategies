package com.exercise.stategies.entities;

import javax.persistence.*;

@Entity
@Table(name="accion")
public class Accion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="precio")
    private String precio;

    @Column(name="fecha")
    private String fecha;

    @Column(name="empresa", length=50)
    private String empresa;

    public Accion() {
    }

    public Integer getId() {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
