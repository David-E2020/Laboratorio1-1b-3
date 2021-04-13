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
public class ProyectoGrado extends MaterialBibliografico implements Serializable{
    static final long serialVersionUID=43L;
    private String tutor;
    private String revisor;
    
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("Tutor: "+this.tutor);
        System.out.println("Revisor: "+this.revisor);
    }
    
    //geter and seter
    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }
    
}

