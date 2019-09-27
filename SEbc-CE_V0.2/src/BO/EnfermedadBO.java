/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.util.ArrayList;

/**
 *
 * @author Jose R
 */
public class EnfermedadBO {
    public String nombre;
    public ArrayList sintomas;

    public EnfermedadBO(String nombre) {
        this.nombre = nombre;
        this.sintomas = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas.add(sintomas);
    }
}
