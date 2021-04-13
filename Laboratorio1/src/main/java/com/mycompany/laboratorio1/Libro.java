/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorio1;

import java.io.Serializable;

/**
 *
 * @author david
 */
public class Libro extends MaterialBibliografico implements Serializable{
    static final long serialVersionUID=44L;
    private int edicion;
    private String area;
    
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("Edicion: "+this.edicion);
        System.out.println("Area: "+this.area);
    }
    
    //geter and seter

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
}

