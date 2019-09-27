/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEbcv0;

import com.sun.awt.AWTUtilities;
import BO.EnfermedadBO;
import Class.MotorBusqueda;
import gov.nih.nlm.nls.metamap.Ev;
import gov.nih.nlm.nls.metamap.Mapping;
import gov.nih.nlm.nls.metamap.MetaMapApi;
import gov.nih.nlm.nls.metamap.MetaMapApiImpl;
import gov.nih.nlm.nls.metamap.PCM;
import gov.nih.nlm.nls.metamap.Result;
import gov.nih.nlm.nls.metamap.Utterance;
import java.awt.Shape;
import java.awt.geom.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Jose R
 */
public class SEbc extends javax.swing.JFrame {

    private final String SEMANTIC_TYPES[] = {"sosy", "diap", "dsyn", "fndg", "lbpr", "lbtr"};
    private MetaMapApi mmapi;

    String sk13 = "org.jvnet.substance.skin.MistAquaSkin";
    String st23 = "org.jvnet.substance.theme.SubstanceTerracoĀaTheme";
    int x, y;
    int state;

    public SEbc() {
        setUndecorated(true);
        setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin(sk13);
        SubstanceLookAndFeel.setCurrentTheme(st23);
        initComponents();
        Shape shp = new RoundRectangle2D.Double(1, 1, this.getBounds().width, this.getBounds().height, 35, 35);
        AWTUtilities.setWindowShape(this, shp);

        setResizable(false);

        btnCancelar.setFocusable(false);
        btnAceptar.setFocusable(false);
        btnCrearArchivo.setFocusable(false);
        btnGuardarArchivo.setFocusable(false);
        btnSeleccionarEnf.setFocusable(false);
        btnSeleccionarSintomas.setFocusable(false);
        //btnClose.setFocusable(false);
        //btnMin.setFocusable(false);

        btnCancelar.setEnabled(false);
        btnAceptar.setEnabled(false);
        btnSeleccionarEnf.setEnabled(false);
        btnSeleccionarSintomas.setEnabled(false);
        btnGuardarArchivo.setEnabled(false);

        txtPathArchivoEnf.setEnabled(false);
        txtPathArchivoSint.setEnabled(false);
        txtPathNuevoArchivo.setEnabled(false);

        setLocationRelativeTo(null);

        this.mmapi = new MetaMapApiImpl();
        this.mmapi.setOptions("-R SNOMEDCT_US");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrearArchivo = new javax.swing.JButton();
        btnGuardarArchivo = new javax.swing.JButton();
        btnSeleccionarEnf = new javax.swing.JButton();
        btnSeleccionarSintomas = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtPathNuevoArchivo = new javax.swing.JTextField();
        txtPathArchivoEnf = new javax.swing.JTextField();
        txtPathArchivoSint = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCrearArchivo.setText("Crear archivo");
        btnCrearArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearArchivoActionPerformed(evt);
            }
        });

        btnGuardarArchivo.setText("Buscar");
        btnGuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarArchivoActionPerformed(evt);
            }
        });

        btnSeleccionarEnf.setText("Buscar");
        btnSeleccionarEnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarEnfActionPerformed(evt);
            }
        });

        btnSeleccionarSintomas.setText("Buscar");
        btnSeleccionarSintomas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarSintomasActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel1.setText("Guardar archivo:");

        jLabel2.setText("Archivo Enfermedad:");

        jLabel3.setText("Archivo Síntomas:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCrearArchivo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtPathNuevoArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarArchivo)
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPathArchivoSint)
                            .addComponent(txtPathArchivoEnf))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSeleccionarEnf)
                            .addComponent(btnSeleccionarSintomas))
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAceptar)
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btnCrearArchivo)
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarArchivo)
                    .addComponent(txtPathNuevoArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPathArchivoEnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarEnf))
                .addGap(7, 7, 7)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionarSintomas)
                    .addComponent(txtPathArchivoSint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearArchivoActionPerformed
        // TODO add your handling code here:
        btnCrearArchivo.setEnabled(false);

        btnCancelar.setEnabled(true);
        btnGuardarArchivo.setEnabled(true);
        btnSeleccionarEnf.setEnabled(true);
        btnSeleccionarSintomas.setEnabled(true);
        btnAceptar.setEnabled(true);
        //txtEnfermedades.setEnabled(true);
        //txtSintomas.setEnabled(true);
        //txtArchivo.setEnabled(true);
    }//GEN-LAST:event_btnCrearArchivoActionPerformed

    private void btnGuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarArchivoActionPerformed
        // TODO add your handling code here:
        String separador = System.getProperty("file.separator");
        JFileChooser sDire = new JFileChooser();
        sDire.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
        if (sDire.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File arch = (File) sDire.getSelectedFile();
            txtPathNuevoArchivo.setText(arch.getPath() + separador);
        }

        if (txtPathArchivoEnf.getText().length() != 0 && txtPathArchivoSint.getText().length() != 0) {
            state = 1;
        } else {
            state = 0;
        }
    }//GEN-LAST:event_btnGuardarArchivoActionPerformed

    private void btnSeleccionarEnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarEnfActionPerformed
        // TODO add your handling code here:
        String separador = System.getProperty("file.separator");
        JFileChooser sDire = new JFileChooser();
        sDire.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if (sDire.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File arch = (File) sDire.getSelectedFile();
            txtPathArchivoEnf.setText(arch.getPath() + separador);
        }
        if (txtPathArchivoEnf.getText().length() != 0 && txtPathArchivoSint.getText().length() != 0) {
            state = 1;
        } else {
            state = 0;
        }
    }//GEN-LAST:event_btnSeleccionarEnfActionPerformed

    private void btnSeleccionarSintomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarSintomasActionPerformed
        // TODO add your handling code here:
        JFileChooser sDire = new JFileChooser();
        sDire.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".TXT,.DIS", "txt", "dis");
        sDire.setFileFilter(filtro);
        if (sDire.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File arch = (File) sDire.getSelectedFile();
            txtPathArchivoSint.setText(arch.getPath());
        }

        if (txtPathNuevoArchivo.getText().length() != 0 && txtPathArchivoEnf.getText().length() != 0) {
            state = 1;
            if (state != 0) {
                //btnAceptar.setEnabled(true);
            }
        } else {
            state = 0;
        }
    }//GEN-LAST:event_btnSeleccionarSintomasActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        btnCrearArchivo.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnAceptar.setEnabled(false);
        btnGuardarArchivo.setEnabled(false);
        btnSeleccionarEnf.setEnabled(false);
        btnSeleccionarSintomas.setEnabled(false);

        //txtEnfermedades.setEnabled(false);
        //txtSintomas.setEnabled(false);
        //txtArchivo.setEnabled(false);
        clean();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        ClasificarEnfermedades();
    }//GEN-LAST:event_btnAceptarActionPerformed

    /*Metodos*/
    public void ClasificarEnfermedades() {
        String nombreFichE = txtPathArchivoEnf.getText();
        String nombreSin = txtPathArchivoSint.getText();
        String fileC = txtPathNuevoArchivo.getText();

        ArrayList sintomas = new ArrayList<>();

        String Dis = "";
        File ficheroE = new File(nombreFichE);
        File[] listOfFiles = ficheroE.listFiles();
        String text = "";
        String texto = "";

        int d1 = size(nombreSin);
        String linea;
        String matriz[][] = new String[d1][2];
        int i = 0;
        String[] a = new String[d1];
        try {
            BufferedReader sin = new BufferedReader(new FileReader(nombreSin));

            while ((linea = sin.readLine()) != null) {
                a = linea.split(":");
                for (int j = 0; j < a.length; j++) {
                    matriz[i][j] = a[j];
                }
                i++;
            }

            for (int e = 0; e < listOfFiles.length; e++) {
                BufferedReader Enf = new BufferedReader(new FileReader(listOfFiles[e].getPath()));
                String name = listOfFiles[e].getName();
                while ((text = Enf.readLine()) != null) {
                    texto += text;
                }
                for (int h = 0; h < matriz.length; h++) {
                    for (int o = 1; o < matriz[0].length; o++) {
                        String sint = matriz[h][o];
                        if (palabras(sint, texto) > 0) {
                            sintomas.add("Sintoma: " + sint);
                        }
                    }
                }
                String Enfermedad = name;
                Iterator it = sintomas.iterator();
                String Sintomas = "";
                while (it.hasNext()) {
                    Sintomas += it.next()+"\r\n";
                }
                
                Dis += "Enfermedad: "+Enfermedad +"\r\n"+
                        Sintomas + "\r\n";
            }
            System.out.print(Dis);
            File destino = new File(fileC + "Base de Conocimiento.txt");
            FileWriter escribir=new FileWriter(destino,true);
            escribir.write(Dis);
            escribir.close();
            
            JOptionPane.showMessageDialog(null,"Base de conocimineoto creada");
        } catch (Exception e) {

        }
    }

    public int palabras(String palabra, String TextoBuscado) {
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

    public void clean() {
        txtPathNuevoArchivo.setText("");
        txtPathArchivoEnf.setText("");
        txtPathArchivoSint.setText("");

        btnCrearArchivo.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnAceptar.setEnabled(false);
        btnGuardarArchivo.setEnabled(false);
        btnSeleccionarEnf.setEnabled(false);
        btnSeleccionarSintomas.setEnabled(false);
    }

    public int size(String nombreFichS) {
        int s = 0;
        try {
            BufferedReader fich = new BufferedReader(new FileReader(nombreFichS));
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

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SEbc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SEbc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SEbc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SEbc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SEbc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrearArchivo;
    private javax.swing.JButton btnGuardarArchivo;
    private javax.swing.JButton btnSeleccionarEnf;
    private javax.swing.JButton btnSeleccionarSintomas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtPathArchivoEnf;
    private javax.swing.JTextField txtPathArchivoSint;
    private javax.swing.JTextField txtPathNuevoArchivo;
    // End of variables declaration//GEN-END:variables
}
