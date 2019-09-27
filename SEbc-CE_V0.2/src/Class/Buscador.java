/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jose R
 */
public class Buscador {
   public static ArrayList<String> cadenas = new ArrayList<String>();
    public static ArrayList<String> palabras = new ArrayList<String>();
    public static ArrayList<String> encontradas = new ArrayList<String>();
    public static Scanner sc = new Scanner(System.in);
    public static int nencontradas = 0;
 
    public static void main(String[] args) {
        System.out.println("Empieza a ingresar las cadenas en donde haras la busqueda\n");
        gen_elems("cadena");
        System.out.println("Empieza a ingresar las palabras a buscar\n");
        gen_elems("palabra");
        if (busqueda()) {
            System.out.println("RESULTADOS:\nSe marcan las coincidencias entre << >>");
            System.out.format("Coincidencias encontradas: %d\n", nencontradas);
            System.out.format("Cadenas a mostrar: %d\n\n", encontradas.size());
            for (String encontrada: encontradas) {
                System.out.println(encontrada);
            }
        } else {
            System.out.println("NO SE ENCONTRARON COINCIDENCIAS EN LA BUSQUEDA");
        }
    }
 
    public static void gen_elems(String tipo) {
        String elem = "";
        String continuar = "";
        int i = 1;
        while (true) {
            System.out.format("Ingresa la %s %d :\n", tipo, i);
            elem = sc.nextLine();
            if ( ! elem.trim().isEmpty()) {
                if (tipo == "cadena") {
                    cadenas.add(elem.trim());
                } else {
                    palabras.add(elem.trim());
                }
                System.out.format("¿Deseas ingresar otra %s? (S o N)\n", tipo);
                continuar = sc.nextLine();
                if (continuar.toUpperCase().equals("N")) {
                    System.out.println("");
                    break;
                }
            } else {
                System.out.format("La %s no puede estar vacia, intentalo de nuevo.\n", tipo);
                i--;
            }
            i++;
        }
    }
 
    public static boolean busqueda() {
        String patron = String.join("|", palabras);
        for (String cadena: cadenas) {
            Pattern pattern = Pattern.compile("\\b(" + patron + ")\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(cadena);
            String cadena_modif = "";
            while (matcher.find()) {
                nencontradas++;
                cadena_modif = cadena.replaceAll("\\b(?i)(" + matcher.group(1) + ")\\b", "<<$1>>");
            }
            if( ! cadena_modif.isEmpty()) encontradas.add(cadena_modif);
        }
        if (encontradas.size() > 0) return true;
        return false;
    } 
}
