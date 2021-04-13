package com.mycompany.laboratorio1;

import java.io.Serializable;

/**
 *
 * @author david
 */
public class MaterialBibliografico implements Serializable{
    static final long serialVersionUID=42L;
    //atributos
    private String titulo;
    private String autor;
    
    public void mostrar(){
        System.out.println("Titulo: "+this.titulo);
        System.out.println("Autor: "+this.autor);
    }
    
    //geter and seter

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
