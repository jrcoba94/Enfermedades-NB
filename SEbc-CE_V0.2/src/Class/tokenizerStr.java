/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.StringTokenizer;

/**
 *
 * @author Jose R
 */
public class tokenizerStr {
        public static void main(String[] args) {
	    String nombre="Angel Franco García";
	    StringTokenizer tokens=new StringTokenizer(nombre);
        while(tokens.hasMoreTokens()){
            System.out.println(tokens.nextToken());
        }

	    String strDatos="6.3\n6.2\n6.4\n6.2";
	    tokens=new StringTokenizer(strDatos, "\n");
        int nDatos=tokens.countTokens();
        double[] datos=new double[nDatos];
        int i=0;
        while(tokens.hasMoreTokens()){
            String str=tokens.nextToken();
            datos[i]=Double.valueOf(str).doubleValue();
            System.out.println(datos[i]);
            i++;
        }

        try  {
//espera la pulsación de una tecla y luego RETORNO
            System.in.read();
        }catch (Exception e) {  }
    }
}