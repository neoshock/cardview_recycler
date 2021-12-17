package com.example.listview_cardview;

public class Evaluado {
    private String Nombres, cargo, fechafin,fechainicio,genero,id,idevaluado,imgJPG,imgjpg,situacion;

    public Evaluado(String nombres, String cargo, String fechafin, String fechainicio, String genero, String id, String idevaluado, String imgJPG, String imgjpg, String situacion) {
        Nombres = nombres;
        this.cargo = cargo;
        this.fechafin = fechafin;
        this.fechainicio = fechainicio;
        this.genero = genero;
        this.id = id;
        this.idevaluado = idevaluado;
        this.imgJPG = imgJPG;
        this.imgjpg = imgjpg;
        this.situacion = situacion;
    }

    public Evaluado() {

    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdevaluado() {
        return idevaluado;
    }

    public void setIdevaluado(String idevaluado) {
        this.idevaluado = idevaluado;
    }

    public String getImgJPG() {
        return imgJPG;
    }

    public void setImgJPG(String imgJPG) {
        this.imgJPG = imgJPG;
    }

    public String getImgjpg() {
        return imgjpg;
    }

    public void setImgjpg(String imgjpg) {
        this.imgjpg = imgjpg;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }
}
