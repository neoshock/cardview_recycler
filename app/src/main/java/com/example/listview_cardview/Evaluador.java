package com.example.listview_cardview;

public class Evaluador {
    private String idevaluador,area,nombres,imgJPG,imgjpg;

    public Evaluador(String idevaluador, String area, String nombres, String imgJPG, String imgjpg) {
        this.idevaluador = idevaluador;
        this.area = area;
        this.nombres = nombres;
        this.imgJPG = imgJPG;
        this.imgjpg = imgjpg;
    }

    public Evaluador() {

    }

    public String getIdevaluador() {
        return idevaluador;
    }

    public void setIdevaluador(String idevaluador) {
        this.idevaluador = idevaluador;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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
}
