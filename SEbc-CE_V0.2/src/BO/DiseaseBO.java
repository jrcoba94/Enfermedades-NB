/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.util.*;

/**
 *
 * @author Jose R
 */
public class DiseaseBO {

    private String name;
    private ArrayList<String> Sintoma;
    private String url;

    public DiseaseBO(String n, String u) {
        this.name = n;
        this.url = u;
        this.Sintoma = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void addSintoma(String t) {
        Sintoma.add(t);
    }

    public String getUrl() {
        return url;
    }

    public String getSintoma() {
        String str = "";
        for (int i = 0; i < Sintoma.size(); i++) {
            str += Sintoma.get(i) + "\n";
        }
        return str;
    }

    public ArrayList<String> getSintomaLines() {
        return Sintoma;
    }
}
