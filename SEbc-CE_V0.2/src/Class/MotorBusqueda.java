/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

//import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;

/**
 *
 * @author Jose R
 */
public class MotorBusqueda {

    private IndexSearcher buscador = null;
    private QueryParser analizador = null;
    String text;

    public boolean buscar(String texto, String pathFile) throws FileNotFoundException, IOException {
        boolean match = false;
        File archivo = new File(pathFile);
        FileReader lectorArchivo = new FileReader(archivo);
        BufferedReader lectorFlujo = new BufferedReader(lectorArchivo);
        String parametro = texto;

        try {
            String lineaTexto = lectorFlujo.readLine(); //Leo la primera línea.
            while (lineaTexto != null) {
                //t1.append(lineaTexto + "\n");
                text = lineaTexto + "\n";
                lineaTexto = lectorFlujo.readLine();
            }
            lectorFlujo.close();
        } catch (Exception e) {
        }

        try {
            Pattern p = Pattern.compile("(?i)" + texto);
            Matcher m = p.matcher(text);
            while (m.find()) {
                if (m.find() == true) {
                    match = true;
                } else {
                    match = false;
                }
            }
        } catch (Exception ex) {
        }
        return match;
    }

    public Hits funcionBuscar(String textoConsulta)
            throws IOException, ParseException, org.apache.lucene.queryParser.ParseException {
        Query query = analizador.parse(textoConsulta);
        Hits hits = buscador.search(query);
        return hits;
    }
}
