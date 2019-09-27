/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 *
 * @author Jose R
 */
public class Numeros {
    public static int palabras(String palabra, String TextoBuscado) {
        boolean mayusculas = true;
        int numPalabras = 0;
        StringTokenizer Busca = new StringTokenizer(TextoBuscado, "\"'!., \t\n()[]?-_@");
        while (Busca.hasMoreTokens() != false) {
            String palabrilla = Busca.nextToken();
            if (mayusculas) {
                if (palabrilla.equals(palabra)) {
                    numPalabras++;
                } else if (palabrilla.toLowerCase().equals(palabra.toLowerCase())) {
                    numPalabras++;
                }
            }
        }
        return numPalabras;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader sin = new BufferedReader(new FileReader("C:/Users/SAMSUNG/Desktop/Sintomas.txt"));
        BufferedReader Enf = new BufferedReader(new FileReader("C:/Users/SAMSUNG/Desktop/Enfermedades/Brucellosis.dis"));
        String text = "";
        String texto = "";

        ArrayList sintomas = new ArrayList<>();
        int d1 = size();
        String linea;
        String matriz[][] = new String[d1][2];
        int i = 0;
        String[] a = new String[d1];

        while ((text = Enf.readLine()) != null) {
            texto += text;
        }

        while ((linea = sin.readLine()) != null) {
            a = linea.split(":");
            for (int j = 0; j < a.length; j++) {
                matriz[i][j] = a[j];
            }
            i++;
        }

        File en = new File("C:/Users/SAMSUNG/Desktop/Enfermedades/Brucellosis.dis");
        System.out.println("Enfermedad: " + en.getName());
        
        for (int h = 0; h < matriz.length; h++) {
            for (int o = 1; o < matriz[0].length; o++) {
                String sint = matriz[h][o];
                if (palabras(sint, texto) > 0) {
                    System.out.println("Sintoma: "+sint);
                }
            }
        }

        //System.out.println("Introduce un una palabra a buscar:");
        //String token = leer.readLine();
//        System.out.println("El resultado es:");
//        System.out.println(palabras(token, texto));
    }

    public static void TranformSinsFile() {
        //metodo para modoficar archivo sifntomas y eliminar "(finding)"
        //String nombreFichS = txtPathArchivoSint.getText();

        try {
            BufferedReader file = new BufferedReader(new FileReader("C:/Users/SAMSUNG/Desktop/Sintomas.txt"));
            String line;
            String input = "";
            while ((line = file.readLine()) != null) {
                String li = line.trim();
                input += li+"\r\n";
            }
            FileOutputStream fileOut = new FileOutputStream("C:/Users/SAMSUNG/Desktop/Sintomas.txt");
            fileOut.write(input.getBytes());
            fileOut.close();
            System.out.print("Operación Realizada con éxito");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public static int size() {
        int s = 0;
        try {
            BufferedReader fich = new BufferedReader(new FileReader("C:/Users/SAMSUNG/Desktop/Sintomas.txt"));
            int contadorL = 0;
            String linea;
            try {
                while ((linea = fich.readLine()) != null) {
                    contadorL++;
                }
                s = contadorL;
            } catch (IOException e) {
            }
        } catch (FileNotFoundException e) {
        }
        return s;
    }
}
